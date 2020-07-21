package com.howmehow.android.calculator

import android.widget.Button
import kotlin.math.sqrt

class Presenter : Contract.Presenter, MathLogic() {

    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var tempNumber: String = ""
    private var functionsButtonPressed: Boolean = false
    private var functionActuallyPressed: String = ""
    private var countAmountOfFunctions: Int = 0

    private lateinit var view: Contract.View

    override fun init(view: Contract.View) {
        this.view = view
    }
//have to rename the functions and variables to have it more clear what's going on
    override fun onButtonPressed(pressedButton: Button) {

        when (pressedButton.text) {
            "AC" -> clearView()
            "+" -> passTheFunction("+")
            "−" -> passTheFunction("−")
            "×" -> passTheFunction("×")
            "÷" -> passTheFunction("÷")
            "√" -> callForSquareRoot()
            "=" -> callForEquals()
            "1" -> replaceOrAddNumber("1")
            "2" -> replaceOrAddNumber("2")
            "3" -> replaceOrAddNumber("3")
            "4" -> replaceOrAddNumber("4")
            "5" -> replaceOrAddNumber("5")
            "6" -> replaceOrAddNumber("6")
            "7" -> replaceOrAddNumber("7")
            "8" -> replaceOrAddNumber("8")
            "9" -> replaceOrAddNumber("9")
            "0" -> replaceOrAddNumber("0")
        }
    }


    private fun passTheFunction(s: String) {
        tempNumber = ""
        functionsButtonPressed = true
        functionActuallyPressed = s
        view.updateTextView(s)
        if (countAmountOfFunctions < 1) {
            countAmountOfFunctions += 1
        }else{
            callForEquals()
            //here we would have to keep the function actually pressed update
            functionActuallyPressed = s
            view.updateTextView(s)
        }
    }

    private fun replaceOrAddNumber(num: String) {
        //that's also buggy because I only check firstNumber.
        if (firstNumber == "0") {
            tempNumber = num
        } else {
            tempNumber += num
        }
        if (!functionsButtonPressed) {
            firstNumber = tempNumber
        } else {
            secondNumber = tempNumber
        }
        view.updateTextView(tempNumber)
    }

    private fun callForEquals() {
        var str = ""
//        val localFirstNumber = firstNumber.toDouble()
//        val localSecondNumber = secondNumber.toDouble()
        when (functionActuallyPressed) {
            "+" -> str = addition(firstNumber.toDouble(), secondNumber.toDouble())
            "−" -> str = subtraction(firstNumber.toDouble(), secondNumber.toDouble())
            "×" -> str = multiplication(firstNumber.toDouble(), secondNumber.toDouble())
            "÷" -> str = division(firstNumber.toDouble(), secondNumber.toDouble())
        }
        //display only floating point if it's not zero?
        //another thing would be to callForEquals when the function button is pressed second time
        countAmountOfFunctions = 1
        firstNumber = str
        secondNumber = "0"
        view.updateTextView(firstNumber)
    }

    private fun callForSquareRoot() {
        var str = ""
        str = squareRoot(firstNumber.toDouble())
        countAmountOfFunctions = 1
        firstNumber = str
        secondNumber = "0"
        view.updateTextView(firstNumber)
        //TODO separate endCall from this one and callforequals
    }

    private fun clearView() {
        countAmountOfFunctions = 0
        firstNumber = ""
        secondNumber = ""
        tempNumber = ""
        functionActuallyPressed = ""
        functionsButtonPressed = false
        view.updateTextView(tempNumber)
    }
}
