package com.howmehow.android.calculator

import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MathematicalOperationsTest {

    @After
    fun tearDown(){
        Mockito.verifyNoMoreInteractions(view)
    }

    @Mock
    lateinit var view: Contract.View

    @Test
    fun `test addition operation`(){
        //given
        val mathOperations = MathematicalOperations
        //when
        val outcome = mathOperations.addition(1.2,2.0)
        //then
        assertEquals("3.2", outcome)
    }

    @Test
    fun `test subtraction operation`(){
        //given
        val mathOperations = MathematicalOperations
        //when
        val outcome = mathOperations.subtraction(2.2,2.0)
        //then
        assertEquals("0.2", outcome)
    }

    @Test
    fun `test multiplication operation`(){
        //given
        val mathOperations = MathematicalOperations
        //when
        val outcome = mathOperations.multiplication(2.0,2.0)
        //then
        assertEquals("4", outcome)
    }

    @Test
    fun `test division operation`(){
        //given
        val mathOperations = MathematicalOperations
        //when
        val outcome = mathOperations.division(2.0,2.0)
        //then
        assertEquals("1", outcome)
    }

    @Test
    fun `test percent operation on first number`(){
        //given
        val mathOperations = MathematicalOperations
        //when
        val outcome = mathOperations.percentOperationOnlyOnFirstNumber(666.0)
        //then
        assertEquals("6.66", outcome)
    }
    @Test
    fun `test percent operation on second number `(){
        //given
        val mathOperations = MathematicalOperations
        //when
        val outcome = mathOperations.percentOperation(10.0,25.0)
        //then
        assertEquals("2.5", outcome)
    }
}