package com.howmehow.android.calculator

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.round
import kotlin.math.roundToLong
import kotlin.math.sqrt


open class MathLogic {

    fun addition(number1: Double, number2: Double): String {
        var number = (number1 + number2)
        return if (number.rem(1).equals(0.0)) {
            number.toInt().toString()
        } else {
            number.toString()
        }
    }

    fun subtraction(number1: Double, number2: Double): String {
        var number = (number1 - number2)
        return if (number.rem(1).equals(0.0)) {
            number.toInt().toString()
        } else {
            number.toString()
        }
    }

    fun multiplication(number1: Double, number2: Double): String {
        var number = (number1 * number2)
        return if (number.rem(1).equals(0.0)) {
            number.toInt().toString()
        } else {
            number.toString()
        }
    }

    fun division(number1: Double, number2: Double): String {
        return if (number2 != 0.0){
            var number = (number1 / number2)
            if (number.rem(1).equals(0.0)) {
                number.toInt().toString()
            } else {
                val decimal = BigDecimal(number).setScale(10, RoundingMode.HALF_EVEN)
                decimal.toString()
            }
        } else {
            "Cannot divide by 0"
        }
    }
    //we gonna have to find out how to trim the number

    fun squareRoot(number1: Double): String {
        return sqrt(number1).toString()
    }
}