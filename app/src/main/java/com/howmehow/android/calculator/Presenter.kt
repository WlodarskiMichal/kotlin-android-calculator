package com.howmehow.android.calculator

import android.widget.Button
import android.widget.Toast

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

    //have to rename the functions and variables to have it more clear what's going on
    override fun onButtonPressed(pressedButton: Button) {
        when (pressedButton.text) {
            "AC" -> clearViewButtonPressed()
            "+" -> operationButtonPressed("+")
            "−" -> operationButtonPressed("−")
            "×" -> operationButtonPressed("×")
            "÷" -> operationButtonPressed("÷")
            "%" -> operationPercent()
            "." -> operationButtonPressed(".")
            "√" -> squareRootButtonPressed()
            "=" -> equalsButtonPressedOnFinal()
            "+/−" -> addOrRemoveMinusButtonPressed()
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

    private fun addOrRemoveMinusButtonPressed() {
        TODO("Not yet implemented")
    }

    private fun operationButtonPressed(s: String) {
        if (firstNumber == "") {
            firstNumber = "0"
        }
//        if (countOperations >= 1){
//            secondNumber = ""////////////////////////////
//        }
        if (countOperations >= 1) {
            equalsButtonPressed()
        }
        operationCall(s)
    }

    private fun operationCall(s: String) {
        operation = s
        view.updateTextView(operation)
        currentNumberInput = 2
        countOperations += 1
    }

    private fun numberButtonPressed(string: String) {
//        if (countOperations > 1) {
//            firstNumber = finalNumber
////            secondNumber = ""////////////////////////////////////
//        }
        if (currentNumberInput == 2) {
            if (secondNumber == "") {
                secondNumber = string
            } else {
                secondNumber += string
            }
            view.updateTextView(secondNumber)
        }
        if (currentNumberInput == 1) {
            if (firstNumber == "") {
                firstNumber = string
            } else {
                firstNumber += string
            }
            view.updateTextView(firstNumber)
        }
    }


    private fun resetNumbers() {
        currentNumberInput = 1
        firstNumber = ""
        secondNumber = ""
    }

    private fun equalsButtonPressed() {
        finalOperationCounted()
        countOperations += 1
        view.updateTextView(firstNumber)
        currentNumberInput = 2
//        firstNumber = finalNumber
        if (firstNumber == "⧜") {
            clearViewButtonPressed()
        }
    }
    private fun equalsButtonPressedOnFinal() {
        finalOperationCounted()
        countOperations = 0
        view.updateTextView(firstNumber)
        currentNumberInput = 2
//        firstNumber = finalNumber
        if (firstNumber == "⧜") {
            clearViewButtonPressed()
        }
    }

    private fun firstNumberOperationCounted() {
        when (operation) {
            "+" -> firstNumber = addition(finalNumber.toDouble(), secondNumber.toDouble())
            "−" -> firstNumber = subtraction(finalNumber.toDouble(), secondNumber.toDouble())
            "×" -> firstNumber = multiplication(finalNumber.toDouble(), secondNumber.toDouble())
            "÷" -> firstNumber = division(finalNumber.toDouble(), secondNumber.toDouble())
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
//TODO have to make sure that you have to press number first and if there is no first number there is no operation possible