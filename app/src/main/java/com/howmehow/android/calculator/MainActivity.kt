package com.howmehow.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Contract.View {

    private val presenter: Contract.Presenter by lazy {
        val presenter = Presenter()
        presenter.init(this)
        presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    private fun setViews() {
        main_button_clear.setOnClickListener {
            presenter.onButtonPressed(main_button_clear)
        }
        main_button_percent.setOnClickListener {
            presenter.onButtonPressed(main_button_percent)
        }
        main_button_square_root.setOnClickListener {
            presenter.onButtonPressed(main_button_square_root)
        }
        main_button_multiply.setOnClickListener {
            presenter.onButtonPressed(main_button_multiply)
        }
        main_button_seven.setOnClickListener {
            presenter.onButtonPressed(main_button_seven)
        }
        main_button_eight.setOnClickListener {
            presenter.onButtonPressed(main_button_eight)
        }
        main_button_nine.setOnClickListener {
            presenter.onButtonPressed(main_button_nine)
        }
        main_button_divide.setOnClickListener {
            presenter.onButtonPressed(main_button_divide)
        }
        main_button_four.setOnClickListener {
            presenter.onButtonPressed(main_button_four)
        }
        main_button_five.setOnClickListener {
            presenter.onButtonPressed(main_button_five)
        }
        main_button_six.setOnClickListener {
            presenter.onButtonPressed(main_button_six)
        }
        main_button_minus.setOnClickListener {
            presenter.onButtonPressed(main_button_minus)
        }
        main_button_one.setOnClickListener {
            presenter.onButtonPressed(main_button_one)
        }
        main_button_two.setOnClickListener {
            presenter.onButtonPressed(main_button_two)
        }
        main_button_three.setOnClickListener {
            presenter.onButtonPressed(main_button_three)
        }
        main_button_plus.setOnClickListener {
            presenter.onButtonPressed(main_button_plus)
        }
        main_button_zero.setOnClickListener {
            presenter.onButtonPressed(main_button_zero)
        }
        main_button_dot.setOnClickListener {
            presenter.onButtonPressed(main_button_dot)
        }
        main_button_turn_to_negative.setOnClickListener {
            presenter.onButtonPressed(main_button_turn_to_negative)
        }
        main_button_equals.setOnClickListener {
            presenter.onButtonPressed(main_button_equals)
        }
    }

    override fun updateTextView(str: String) {
        main_textview_display_numbers.text = str
    }
}
