package com.howmehow.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.View {

    private var arr = arrayListOf<String>()

//    private val presenter: Contract.Presenter by lazy {
//        val presenter = Presenter()
//        presenter.init(this)
//        presenter
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    private fun setViews() {
        main_button_clear.setOnClickListener {
            clearView()
        }
        main_button_percent.setOnClickListener {
            updateView(main_button_square_root.text.toString())
        }
        main_button_square_root.setOnClickListener {
            updateView(main_button_square_root.text.toString())
        }
        main_button_multiply.setOnClickListener {
            updateView(main_button_multiply.text.toString())
        }
        main_button_seven.setOnClickListener {
            updateView(main_button_seven.text.toString())
        }
        main_button_eight.setOnClickListener {
            updateView(main_button_eight.text.toString())
        }
        main_button_nine.setOnClickListener {
            updateView(main_button_nine.text.toString())
        }
        main_button_divide.setOnClickListener {
            updateView(main_button_divide.text.toString())
        }
        main_button_four.setOnClickListener {
            updateView(main_button_four.text.toString())
        }
        main_button_five.setOnClickListener {
            updateView(main_button_five.text.toString())
        }
        main_button_six.setOnClickListener {
            updateView(main_button_six.text.toString())
        }
        main_button_minus.setOnClickListener {
            updateView(main_button_minus.text.toString())
        }
        main_button_one.setOnClickListener {
            updateView(main_button_one.text.toString())
        }
        main_button_two.setOnClickListener {
            updateView(main_button_two.text.toString())
        }
        main_button_three.setOnClickListener {
            updateView(main_button_three.text.toString())
        }
        main_button_plus.setOnClickListener {
            updateView(main_button_plus.text.toString())
        }
        main_button_zero.setOnClickListener {
            updateView(main_button_zero.text.toString())
        }
        main_button_dot.setOnClickListener {
            updateView(main_button_dot.text.toString())
        }
        main_button_turn_to_negative.setOnClickListener {
            turnToNegative()
        }
        main_button_equals.setOnClickListener {
//            getResult(fromView)
//            sendResult(toPresenter)
//            updateView(withResultThatGotBack)
        }
    }

    private fun updateView(number: String) {
        main_textview_display_numbers.text = getBackTheStringOfNumbers(number)
    }
    private fun updateView(){
        main_textview_display_numbers.text = getBackTheStringOfNumbers()
    }

    private fun getBackTheStringOfNumbers(number: String): String {
        var str = ""
        when (number) {
            "1" ->
                //TODO add to previous string at the end
            "2"
            "3"
            "4"
            "5"
            "6"
            "7"
            "8"
            "9"
            "0"
        }
        arr.add(number)
        for (item in arr) {
            str += "$item"
        }
        return str
    }
    private fun getBackTheStringOfNumbers() : String {
        var str = ""
        for (item in arr) {
            str += "$item"
        }
        return str
    }

    private fun clearView() {
        main_textview_display_numbers.text = "0"
        arr.clear()
    }

    private fun turnToNegative() {
        if (arr.isNotEmpty()) {
            var str = arr.last()
            arr.remove(arr.last())
            var temp = "-$str"
            arr.add(temp)
            updateView()
        }
    }
}

//First of all we have to figure out how to add multiple elements as one to array
//we could do something in sense that it would add string to first element and then empty the temp array
//maybe when case or something like that, when it's +/- or something it's gonna add all the elements and move on
//but if it's gonna be number then it's gonna add it to previous number
//TODO we can do presenter the way that it's gonna loop through the array and when it's gonna come across any known symbols it's gonna call function

//TODO figure out if it wouldn't be easier to add brackets. but then you have to figure out which one is gonna be first etc.
//TODO negative button is gonna change the number to minus and add extra space or brackets

//TODO make equals send the numbers to presenter to return working solution in number or in string
//TODO make sure the layout is not moving
//TODO change the font size according to length of the number? or just make it hide above
