package com.howmehow.android.calculator

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PresenterTest {

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(view)
    }

    @Mock
    lateinit var view: Contract.View

    @Test
    fun `test plus button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)

        //when - what happens when we do the test
        presenter.operationButtonPressed("+")
        //then
        verify(view).updateTextView("+")
    }

    @Test
    fun `test minus button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)

        //when - what happens when we do the test
        presenter.operationButtonPressed("-")
        //then
        verify(view).updateTextView("-")
    }

    @Test
    fun `test multiply button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.operationButtonPressed("×")
        //then
        verify(view).updateTextView("×")
    }

    @Test
    fun `test divide button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.operationButtonPressed("÷")
        //then
        verify(view).updateTextView("÷")
    }

    @Test
    fun `test number button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("1")
        //then
        verify(view).updateTextView("1")
    }

    @Test
    fun `test number two button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("2")
        //then
        verify(view).updateTextView("2")
    }

    @Test
    fun `test number three button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("3")
        //then
        verify(view).updateTextView("3")
    }

    @Test
    fun `test number four button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("4")
        //then
        verify(view).updateTextView("4")
    }

    @Test
    fun `test number five button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("5")
        //then
        verify(view).updateTextView("5")
    }

    @Test
    fun `test number six button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("6")
        //then
        verify(view).updateTextView("6")
    }

    @Test
    fun `test number seven button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("7")
        //then
        verify(view).updateTextView("7")
    }

    @Test
    fun `test number eight button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("8")
        //then
        verify(view).updateTextView("8")
    }

    @Test
    fun `test number nine button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("9")
        //then
        verify(view).updateTextView("9")
    }

    @Test
    fun `test number zero button pressed and the user input is shown on text view`() {

        //given - setting the rules/variables
        val presenter: Contract.Presenter = Presenter()
        presenter.init(view)
        //when - what happens when we do the test
        presenter.numberButtonPressed("0")
        //then
        verify(view).updateTextView("0")
    }
}