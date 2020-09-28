package com.howmehow.android.calculator

import android.widget.Button

private const val infinity = "⧜"

class Presenter : Contract.Presenter, MathematicalOperations() {

    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var finalNumber: String = ""
    private var currentNumberInput: Int = 1
    private var operation: String = ""
    private var countOperations: Int = 0

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
            "=" -> equalsButtonPressedOnFinal()
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

    private fun operationButtonPressed(stringFromOperationButton: String) {
        if (firstNumber == "") {
            firstNumber = "0"
        }
        if (countOperations >= 1) {
            equalsButtonPressed()
        }
        operationCall(stringFromOperationButton)
    }

    private fun operationCall(stringFromOperationButton: String) {
        operation = stringFromOperationButton
        view.updateTextView(operation)
        currentNumberInput = 2
        countOperations += 1
    }

    private fun numberButtonPressed(stringFromNumberButton: String) {
        if (stringFromNumberButton == "." && currentNumberInput == 2 && stringFromNumberButton in secondNumber) {
            return
        }

        if (stringFromNumberButton == "." && currentNumberInput == 1 && stringFromNumberButton in firstNumber) {
            return
        }

        if (stringFromNumberButton == "-" && stringFromNumberButton in secondNumber) {
            secondNumber = secondNumber.drop(1)
            view.updateTextView(secondNumber)
            return
        }

        if (stringFromNumberButton == "-" && stringFromNumberButton in firstNumber) {
            firstNumber = firstNumber.drop(1)
            view.updateTextView(firstNumber)
            return
        }

        if (stringFromNumberButton == "-" && currentNumberInput == 2) {
            secondNumber = "$stringFromNumberButton$secondNumber"
            view.updateTextView(secondNumber)
            return
        }

        if (stringFromNumberButton == "-" && currentNumberInput == 1) {
            firstNumber = "$stringFromNumberButton$firstNumber"
            view.updateTextView(firstNumber)
            return
        }

        if (currentNumberInput == 2) {
            if (secondNumber == "") {
                secondNumber = stringFromNumberButton
            } else {
                secondNumber += stringFromNumberButton
            }
            view.updateTextView(secondNumber)
        }

        if (currentNumberInput == 1) {
            if (firstNumber == "") {
                firstNumber = stringFromNumberButton
            } else {
                firstNumber += stringFromNumberButton
            }
            view.updateTextView(firstNumber)
        }
    }

    private fun operationPercent() {
        if (currentNumberInput == 1){
            var tempNumber = firstNumber.toDouble()/100
            firstNumber = tempNumber.toString()
            view.updateTextView(firstNumber)
        }

        if (currentNumberInput == 2){
            var tempNumber = firstNumber.toDouble()/100 * secondNumber.toDouble()
            secondNumber = tempNumber.toString()
            view.updateTextView(secondNumber)
        }
    }

    private fun resetNumbers() {
        currentNumberInput = 1
        firstNumber = ""
        secondNumber = ""
    }

    private fun equalsButtonPressed() {
        if (firstNumber == "" && secondNumber == ""){
            return
        }
        finalOperationCounted()
        countOperations += 1
        view.updateTextView(firstNumber)
        currentNumberInput = 2
        if (firstNumber == infinity) {
            clearViewButtonPressed()
        }
    }

    private fun equalsButtonPressedOnFinal() {
        if (firstNumber == "" && secondNumber == ""){
            return
        }
        finalOperationCounted()
        countOperations = 0
        view.updateTextView(firstNumber)
        currentNumberInput = 2
        if (firstNumber == "⧜") {
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
