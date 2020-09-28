package com.howmehow.android.calculator

import android.widget.Button

private const val infinity = "⧜"

class Presenter : Contract.Presenter, MathematicalOperations() {

    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var finalNumber: String = ""
    /* numberCurrentlyCaptured is by default First. It recognises which number user
    * is currently saving for later operations. */
    private var numberCurrentlyCaptured: String = "First"
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
        numberCurrentlyCaptured = "Second"
        countOperations += 1
    }

    private fun numberButtonPressed(stringFromNumberButton: String) {
        if (stringFromNumberButton == "." && numberCurrentlyCaptured == "Second" && stringFromNumberButton in secondNumber) {
            return
        }

        if (stringFromNumberButton == "." && numberCurrentlyCaptured == "First" && stringFromNumberButton in firstNumber) {
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

        if (stringFromNumberButton == "-" && numberCurrentlyCaptured == "Second") {
            secondNumber = "$stringFromNumberButton$secondNumber"
            view.updateTextView(secondNumber)
            return
        }

        if (stringFromNumberButton == "-" && numberCurrentlyCaptured == "First") {
            firstNumber = "$stringFromNumberButton$firstNumber"
            view.updateTextView(firstNumber)
            return
        }

        if (numberCurrentlyCaptured == "Second") {
            if (secondNumber == "") {
                secondNumber = stringFromNumberButton
            } else {
                secondNumber += stringFromNumberButton
            }
            view.updateTextView(secondNumber)
        }

        if (numberCurrentlyCaptured == "First") {
            if (firstNumber == "") {
                firstNumber = stringFromNumberButton
            } else {
                firstNumber += stringFromNumberButton
            }
            view.updateTextView(firstNumber)
        }
    }

    private fun operationPercent() {
        if (numberCurrentlyCaptured == "First"){
            val tempNumber = firstNumber.toDouble()/100
            firstNumber = tempNumber.toString()
            view.updateTextView(firstNumber)
        }

        if (numberCurrentlyCaptured == "Second"){
            val tempNumber = firstNumber.toDouble()/100 * secondNumber.toDouble()
            secondNumber = tempNumber.toString()
            view.updateTextView(secondNumber)
        }
    }

    private fun resetNumbers() {
        numberCurrentlyCaptured = "First"
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
        numberCurrentlyCaptured = "Second"
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
