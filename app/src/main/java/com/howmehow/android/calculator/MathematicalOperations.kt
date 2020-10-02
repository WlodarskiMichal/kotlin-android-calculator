package com.howmehow.android.calculator

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.sqrt

private const val infinity = "⧜"

object  MathematicalOperations {

    fun addition(number1: Double, number2: Double): String {
        val number = (number1 + number2)
        return if (number.rem(1).equals(0.0)) {
            number.toLong().toString()
        } else {
            val decimal = BigDecimal(number).setScale(9, RoundingMode.HALF_UP)
            decimal.toString().trimEnd('0',',')
        }
    }

    fun subtraction(number1: Double, number2: Double): String {
        val number = (number1 - number2)
        return if (number.rem(1).equals(0.0)) {
            number.toLong().toString()
        } else {
            val decimal = BigDecimal(number).setScale(9, RoundingMode.HALF_UP)
            decimal.toString().trimEnd('0',',')
        }
    }


    fun multiplication(number1: Double, number2: Double): String {
        val number = (number1 * number2)
        return if (number.rem(1).equals(0.0)) {
            number.toLong().toString()
        } else {
            val decimal = BigDecimal(number).setScale(9, RoundingMode.HALF_UP)
            decimal.toString().trimEnd('0',',')
        }
    }

    fun division(number1: Double, number2: Double): String {
        val number = (number1 / number2)
        return if (number1 != 0.0 && number2 != 0.0) {
            if (number.rem(1).equals(0.0)) {
                number.toLong().toString()
            } else {
                val decimal = BigDecimal(number).setScale(9, RoundingMode.HALF_UP)
                decimal.toString().trimEnd('0',',')
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
            val decimal = BigDecimal(number).setScale(9, RoundingMode.HALF_UP)
            decimal.toString().trimEnd('0',',')
        }
    }

    fun percentOperationOnlyOnFirstNumber(number1: Double): String {
        val tempNumber = number1 / 100
        return if (tempNumber.rem(1).equals(0.0)) {
            tempNumber.toLong().toString()
        } else {
            val decimal = BigDecimal(tempNumber).setScale(9, RoundingMode.HALF_UP)
            decimal.toString().trimEnd('0',',')
        }
    }

    fun percentOperation(number1: Double, number2: Double) : String {
        val tempNumber = number1 / 100 * number2
        return if (tempNumber.rem(1).equals(0.0)) {
            tempNumber.toLong().toString()
        } else {
            val decimal = BigDecimal(tempNumber).setScale(9, RoundingMode.HALF_UP)
            decimal.toString().trimEnd('0',',')
        };
    }
}


