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
            currentlyDisplayedNumberRemovingNegation(secondNumber)
            view.updateTextView(secondNumber)
            return
        }

        if (stringFromPressedNumberButton == "-" && stringFromPressedNumberButton in firstNumber) {
            currentlyDisplayedNumberRemovingNegation(firstNumber)
            view.updateTextView(firstNumber)
            return
        }

        if (stringFromPressedNumberButton == "-" && numberCurrentlyCaptured == "Second") {
            secondNumber = "$stringFromPressedNumberButton$secondNumber"
            view.updateTextView(secondNumber)
            return
        }

        if (stringFromPressedNumberButton == "-" && numberCurrentlyCaptured == "First") {
            firstNumber = "$stringFromPressedNumberButton$firstNumber"
            view.updateTextView(firstNumber)
            return
        }

        if (numberCurrentlyCaptured == "Second") {
            if (secondNumber.isEmpty()) {
                secondNumber = stringFromPressedNumberButton
            } else {
                secondNumber += stringFromPressedNumberButton
            }
            view.updateTextView(secondNumber)
        }

        if (numberCurrentlyCaptured == "First") {
            if (firstNumber.isEmpty()) {
                firstNumber = stringFromPressedNumberButton
            } else {
                firstNumber += stringFromPressedNumberButton
            }
            view.updateTextView(firstNumber)
        }
    }

    private fun currentlyDisplayedNumberRemovingNegation(currentNumber: String) {
        if (currentNumber == firstNumber) {
            firstNumber = firstNumber.drop(1)
        }
        if (currentNumber == secondNumber) {
            secondNumber = secondNumber.drop(1)
        }
    }

    override fun operationPercentButtonPressed() {
        if (numberCurrentlyCaptured == "First") {
            firstNumber =
                MathematicalOperations.percentOperationOnlyOnFirstNumber(firstNumber.toDouble())
            view.updateTextView(firstNumber)
        }

        if (numberCurrentlyCaptured == "Second") {
            secondNumber = MathematicalOperations.percentOperation(
                firstNumber.toDouble(),
                secondNumber.toDouble()
            )
            view.updateTextView(secondNumber)
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
                MathematicalOperations.addition(firstNumber.toDouble(), secondNumber.toDouble())
            "−" -> finalNumber = MathematicalOperations.subtraction(
                firstNumber.toDouble(),
                secondNumber.toDouble()
            )
            "×" -> finalNumber = MathematicalOperations.multiplication(
                firstNumber.toDouble(),
                secondNumber.toDouble()
            )
            "÷" -> finalNumber =
                MathematicalOperations.division(firstNumber.toDouble(), secondNumber.toDouble())
        }
        secondNumber = ""
        firstNumber = finalNumber
    }

    override fun squareRootButtonPressed() {
        finalNumber = MathematicalOperations.squareRoot(firstNumber.toDouble())
        countOperations = 1
        view.updateTextView(finalNumber)
        firstNumber = finalNumber
        secondNumber = ""
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
        numberCurrentlyCaptured = "First"

        if (firstNumber == infinity) {
            clearViewButtonPressed()
        }
    }

    override fun clearViewButtonPressed() {
        resetNumbers()
        countOperations = 0
        view.updateTextView("")
    }
}
