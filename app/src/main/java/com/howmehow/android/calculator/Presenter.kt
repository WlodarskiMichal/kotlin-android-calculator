package com.howmehow.android.calculator

private const val infinity = "⧜"

/* numberCurrentlyCaptured is by default First. It recognises which number user
* is currently saving for later operations. */

class Presenter : Contract.Presenter {

    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var finalNumber: String = ""
    private var operation: String = ""
    private var countOperations: Int = 0
    private var numberCurrentlyCaptured: String = "First"
    private var allNumbersAndOperationsCurrentlyUsed: String = ""

    private lateinit var view: Contract.View

    override fun init(view: Contract.View) {
        this.view = view
    }

    override fun operationButtonPressed(stringFromPressedOperationButton: String) {
        if (firstNumber.isEmpty()) {
            firstNumber = "0"
        }

        if (countOperations >= 1) {
            equalsFunctionCalledFromOperationButton()
        }

        operationCall(stringFromPressedOperationButton)
    }

    private fun operationCall(stringFromPressedOperationButton: String) {
        operation = stringFromPressedOperationButton
        view.updateTextView(operation)
        when {
            allNumbersAndOperationsCurrentlyUsed.endsWith("+", false) -> { dropLastOperationSign()}
            allNumbersAndOperationsCurrentlyUsed.endsWith("−", false) -> { dropLastOperationSign()}
            allNumbersAndOperationsCurrentlyUsed.endsWith("÷", false) -> { dropLastOperationSign()}
            allNumbersAndOperationsCurrentlyUsed.endsWith("×", false) -> { dropLastOperationSign()}}
        allNumbersAndOperationsCurrentlyUsed += operation
        view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
        numberCurrentlyCaptured = "Second"
        countOperations += 1
    }

    override fun numberButtonPressed(stringFromPressedNumberButton: String) {
        if (stringFromPressedNumberButton == "." && numberCurrentlyCaptured == "Second" && stringFromPressedNumberButton in secondNumber) {
            return
        }

        if (stringFromPressedNumberButton == "." && numberCurrentlyCaptured == "First" && stringFromPressedNumberButton in firstNumber) {
            return
        }

        if (stringFromPressedNumberButton == "-" && stringFromPressedNumberButton in secondNumber) {
            return
        }

        if (stringFromPressedNumberButton == "-" && stringFromPressedNumberButton in firstNumber) {
            return
        }

        if (stringFromPressedNumberButton == "-" && numberCurrentlyCaptured == "Second") {
            allNumbersAndOperationsCurrentlyUsed =
                allNumbersAndOperationsCurrentlyUsed.dropLast(secondNumber.length)
            secondNumber = "$stringFromPressedNumberButton$secondNumber"
            view.updateTextView(secondNumber)
            allNumbersAndOperationsCurrentlyUsed += " $secondNumber"
            view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
            return
        }

        if (stringFromPressedNumberButton == "-" && numberCurrentlyCaptured == "First") {
            allNumbersAndOperationsCurrentlyUsed =
                allNumbersAndOperationsCurrentlyUsed.dropLast(firstNumber.length)
            firstNumber = "$stringFromPressedNumberButton$firstNumber"
            view.updateTextView(firstNumber)
            allNumbersAndOperationsCurrentlyUsed += " $firstNumber"
            view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
            return
        }

        if (numberCurrentlyCaptured == "Second") {
            if (secondNumber.isEmpty()) {
                secondNumber = stringFromPressedNumberButton
                allNumbersAndOperationsCurrentlyUsed += stringFromPressedNumberButton
            } else if (secondNumber.count() < 14) {
                secondNumber += stringFromPressedNumberButton
                allNumbersAndOperationsCurrentlyUsed += stringFromPressedNumberButton
            }
            view.updateTextView(secondNumber)
            view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
        }

        if (numberCurrentlyCaptured == "First") {
            if (firstNumber.isEmpty()) {
                firstNumber = stringFromPressedNumberButton
                allNumbersAndOperationsCurrentlyUsed += stringFromPressedNumberButton
            } else if (firstNumber.count() < 14) {
                firstNumber += stringFromPressedNumberButton
                allNumbersAndOperationsCurrentlyUsed += stringFromPressedNumberButton
            }
            view.updateTextView(firstNumber)
            view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
        }
    }

    override fun operationPercentButtonPressed() {
        if (firstNumber == "") {
            return
        } else {
            if (numberCurrentlyCaptured == "First") {
                firstNumber =
                    MathematicalOperations.percentOperationOnlyOnFirstNumber(firstNumber.toDouble())
                view.updateTextView(firstNumber)
                allNumbersAndOperationsCurrentlyUsed += " /100 = $firstNumber"
                view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
            }

            if (numberCurrentlyCaptured == "Second") {
                if (secondNumber == "") {
                    return
                } else {
                    secondNumber = MathematicalOperations.percentOperation(
                        firstNumber.toDouble(),
                        secondNumber.toDouble()
                    )
                    view.updateTextView(secondNumber)
                    allNumbersAndOperationsCurrentlyUsed += "%"
                    view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
                }
            }
        }
    }

    private fun resetNumbers() {
        numberCurrentlyCaptured = "First"
        firstNumber = ""
        secondNumber = ""
    }

    private fun finalOperationCounted() {
        when (operation) {
            "+" -> finalNumber =
                MathematicalOperations.addition(
                    firstNumber.toDouble(),
                    secondNumber.toDouble())
            "−" -> finalNumber = MathematicalOperations.subtraction(
                firstNumber.toDouble(),
                secondNumber.toDouble()
            )
            "×" -> finalNumber = MathematicalOperations.multiplication(
                firstNumber.toDouble(),
                secondNumber.toDouble()
            )
            "÷" -> finalNumber =
                MathematicalOperations.division(
                    firstNumber.toDouble(),
                    secondNumber.toDouble())
        }
        secondNumber = ""
        firstNumber = finalNumber
    }

    override fun squareRootButtonPressed() {
        if (firstNumber == "") {
            return
        } else {
            finalNumber = MathematicalOperations.squareRoot(firstNumber.toDouble())
            countOperations = 1
            view.updateTextView(finalNumber)
            allNumbersAndOperationsCurrentlyUsed += "  √$firstNumber = $finalNumber"
            view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
            firstNumber = finalNumber
            secondNumber = ""
        }
    }

    private fun checkIfNumberStringIsEmpty(): Boolean {
        if (firstNumber.isEmpty() || firstNumber == "-") {
            return true
        }
        if (secondNumber.isEmpty() || secondNumber == "-") {
            return true
        }
        return false;
    }

    private fun dropLastOperationSign() : String{
        allNumbersAndOperationsCurrentlyUsed = allNumbersAndOperationsCurrentlyUsed.dropLast(1)
        return allNumbersAndOperationsCurrentlyUsed
    }

    private fun equalsFunctionCalledFromOperationButton() {
        if (checkIfNumberStringIsEmpty()) {
            return
        }

        finalOperationCounted()
        countOperations += 1
        view.updateTextView(firstNumber)
        numberCurrentlyCaptured = "First"

        if (firstNumber == infinity) {
            clearViewButtonPressed()
        }
    }

    override fun equalsButtonPressed() {
        if (checkIfNumberStringIsEmpty()) {
            return
        }

        finalOperationCounted()
        countOperations = 0
        view.updateTextView(firstNumber)
        allNumbersAndOperationsCurrentlyUsed += " = "
        view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
        allNumbersAndOperationsCurrentlyUsed += firstNumber
        view.updateSecondTextView(allNumbersAndOperationsCurrentlyUsed)
        numberCurrentlyCaptured = "First"

        if (firstNumber == infinity) {
            clearViewButtonPressed()
        }
    }

    override fun clearViewButtonPressed() {
        resetNumbers()
        countOperations = 0
        view.updateTextView("")
        allNumbersAndOperationsCurrentlyUsed = ""
        view.updateSecondTextView("")
    }
}
