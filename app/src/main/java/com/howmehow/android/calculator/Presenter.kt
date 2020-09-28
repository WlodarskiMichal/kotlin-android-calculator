package com.howmehow.android.calculator

import android.widget.Button

private const val infinity = "⧜"

/* numberCurrentlyCaptured is by default First. It recognises which number user
* is currently saving for later operations. */

class Presenter : Contract.Presenter, MathematicalOperations() {

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

    override fun onButtonPressed(pressedButton: Button) {
        when (pressedButton.text) {
            "AC" -> clearViewButtonPressed()
            "+" -> operationButtonPressed("+")
            "−" -> operationButtonPressed("−")
            "×" -> operationButtonPressed("×")
            "÷" -> operationButtonPressed("÷")
            "%" -> operationPercent()
            "." -> numberButtonPressed(".")
            "√" -> squareRootButtonPressed()
            "=" -> equalsButtonPressed()
            "+/−" -> numberButtonPressed("-")
            "1" -> numberButtonPressed("1")
            "2" -> numberButtonPressed("2")
            "3" -> numberButtonPressed("3")
            "4" -> numberButtonPressed("4")
            "5" -> numberButtonPressed("5")
            "6" -> numberButtonPressed("6")
            "7" -> numberButtonPressed("7")
            "8" -> numberButtonPressed("8")
            "9" -> numberButtonPressed("9")
            "0" -> numberButtonPressed("0")
        }
    }

    private fun operationButtonPressed(stringFromPressedOperationButton: String) {
        if (firstNumber == "") {
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

    private fun numberButtonPressed(stringFromPressedNumberButton: String) {
        if (stringFromPressedNumberButton == "." && numberCurrentlyCaptured == "Second" && stringFromPressedNumberButton in secondNumber) {
            return
        }

        if (stringFromPressedNumberButton == "." && numberCurrentlyCaptured == "First" && stringFromPressedNumberButton in firstNumber) {
            return
        }

        if (stringFromPressedNumberButton == "-" && stringFromPressedNumberButton in secondNumber) {
            currentlyDisplayedNumberNegation(secondNumber)
            return
        }

        if (stringFromPressedNumberButton == "-" && stringFromPressedNumberButton in firstNumber) {
            currentlyDisplayedNumberNegation(firstNumber)
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
            if (secondNumber == "") {
                secondNumber = stringFromPressedNumberButton
            } else {
                secondNumber += stringFromPressedNumberButton
            }
            view.updateTextView(secondNumber)
        }

        if (numberCurrentlyCaptured == "First") {
            if (firstNumber == "") {
                firstNumber = stringFromPressedNumberButton
            } else {
                firstNumber += stringFromPressedNumberButton
            }
            view.updateTextView(firstNumber)
        }
    }

    private fun currentlyDisplayedNumberNegation(currentNumber: String) {
        if (currentNumber == secondNumber) {
            secondNumber = secondNumber.drop(1)
            view.updateTextView(secondNumber)
        } else if (currentNumber == firstNumber) {
            firstNumber = firstNumber.drop(1)
            view.updateTextView(firstNumber)
        }
    }

    private fun operationPercent() {
        if (numberCurrentlyCaptured == "First") {
            val tempNumber = firstNumber.toDouble() / 100
            firstNumber = tempNumber.toString()
            view.updateTextView(firstNumber)
        }

        if (numberCurrentlyCaptured == "Second") {
            val tempNumber = firstNumber.toDouble() / 100 * secondNumber.toDouble()
            secondNumber = tempNumber.toString()
            view.updateTextView(secondNumber)
        }
    }

    private fun resetNumbers() {
        numberCurrentlyCaptured = "First"
        firstNumber = ""
        secondNumber = ""
    }

    private fun equalsFunctionCalledFromOperationButton() {
        if (firstNumber == "" && secondNumber == "") {
            return
        }

        finalOperationCounted()
        countOperations += 1
        view.updateTextView(firstNumber)
        numberCurrentlyCaptured = "Second"

        if (firstNumber == infinity) {
            clearViewButtonPressed()
        }
    }

    private fun equalsButtonPressed() {
        if (firstNumber == "" || secondNumber == "") {
            return
        }

        finalOperationCounted()
        countOperations = 0
        view.updateTextView(firstNumber)
        numberCurrentlyCaptured = "Second"

        if (firstNumber == infinity) {
            clearViewButtonPressed()
        }
    }

    private fun finalOperationCounted() {
        when (operation) {
            "+" -> finalNumber = addition(firstNumber.toDouble(), secondNumber.toDouble())
            "−" -> finalNumber = subtraction(firstNumber.toDouble(), secondNumber.toDouble())
            "×" -> finalNumber = multiplication(firstNumber.toDouble(), secondNumber.toDouble())
            "÷" -> finalNumber = division(firstNumber.toDouble(), secondNumber.toDouble())
        }
        secondNumber = ""
        firstNumber = finalNumber
    }

    private fun squareRootButtonPressed() {
        finalNumber = squareRoot(firstNumber.toDouble())
        countOperations = 1
        view.updateTextView(finalNumber)
        firstNumber = finalNumber
        secondNumber = ""
    }

    private fun clearViewButtonPressed() {
        resetNumbers()
        countOperations = 0
        view.updateTextView("")
    }
}
