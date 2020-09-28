package com.howmehow.android.calculator

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.sqrt

private const val infinity = "⧜"

open class MathematicalOperations {

    fun addition(number1: Double, number2: Double): String {
        val number = (number1 + number2)
        return if (number.rem(1).equals(0.0)) {
            longNumberStringReturned(number)
        } else {
            bigDecimalStringReturned(number)
        }
    }

    fun subtraction(number1: Double, number2: Double): String {
        val number = (number1 - number2)
        return if (number.rem(1).equals(0.0)) {
            longNumberStringReturned(number)
        } else {
            bigDecimalStringReturned(number)
        }
    }


    fun multiplication(number1: Double, number2: Double): String {
        val number = (number1 * number2)
        return if (number.rem(1).equals(0.0)) {
            longNumberStringReturned(number)
        } else {
            bigDecimalStringReturned(number)
        }
    }

    fun division(number1: Double, number2: Double): String {
        return if (number1 != 0.0 && number2 != 0.0) {
            val number = (number1 / number2)
            if (number.rem(1).equals(0.0)) {
                longNumberStringReturned(number)
            } else {
                bigDecimalStringReturned(number)
            }
        } else {
            infinity
        }
    }

    fun squareRoot(number1: Double): String {
        return sqrt(number1).toString().trimEnd('0')
    }

    private fun bigDecimalStringReturned(number: Double): String {
        val decimal = BigDecimal(number).setScale(10, RoundingMode.HALF_UP)
        return decimal.toString().trimEnd('0')
    }

    private fun longNumberStringReturned(number: Double): String {
        return number.toLong().toString().trimEnd('0')
    }
}
