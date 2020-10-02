package com.howmehow.android.calculator

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.sqrt

private const val infinity = "⧜"

open class MathematicalOperations {

    fun addition(number1: Double, number2: Double): String {
        val number = (number1 + number2)
        return if (number.rem(1).equals(0.0)) {
            number.toLong().toString()
        } else {
            val decimal = BigDecimal(number).setScale(3, RoundingMode.HALF_UP)
            decimal.toString()
        }
    }

    fun subtraction(number1: Double, number2: Double): String {
        val number = (number1 - number2)
        return if (number.rem(1).equals(0.0)) {
            number.toLong().toString()
        } else {
            val decimal = BigDecimal(number).setScale(3, RoundingMode.HALF_UP)
            decimal.toString()
        }
    }


    fun multiplication(number1: Double, number2: Double): String {
        val number = (number1 * number2)
        return if (number.rem(1).equals(0.0)) {
            number.toLong().toString()
        } else {
            val decimal = BigDecimal(number).setScale(3, RoundingMode.HALF_UP)
            decimal.toString()
        }
    }

    fun division(number1: Double, number2: Double): String {
        val number = (number1 / number2)
        return if (number1 != 0.0 && number2 != 0.0) {
            if (number.rem(1).equals(0.0)) {
                number.toLong().toString()
            } else {
                val decimal = BigDecimal(number).setScale(3, RoundingMode.HALF_UP)
                decimal.toString()
            }
        } else {
            infinity
        }
    }

    fun squareRoot(number1: Double): String {
        val number = sqrt(number1)
        return if (number.rem(1).equals(0.0)) {
            number.toLong().toString()
        } else {
            val decimal = BigDecimal(number).setScale(3, RoundingMode.HALF_UP)
            decimal.toString()
        }

    }
}


