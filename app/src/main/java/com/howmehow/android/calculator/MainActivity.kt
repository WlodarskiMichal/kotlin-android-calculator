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
            presenter.onButtonPressed(main_button_clear.text)
        }
        main_button_percent.setOnClickListener {
            presenter.onButtonPressed(main_button_percent.text)
        }
        main_button_square_root.setOnClickListener {
            presenter.onButtonPressed(main_button_square_root.text)
        }
        main_button_multiply.setOnClickListener {
            presenter.onButtonPressed(main_button_multiply.text)
        }
        main_button_seven.setOnClickListener {
            presenter.onButtonPressed(main_button_seven.text)
        }
        main_button_eight.setOnClickListener {
            presenter.onButtonPressed(main_button_eight.text)
        }
        main_button_nine.setOnClickListener {
            presenter.onButtonPressed(main_button_nine.text)
        }
        main_button_divide.setOnClickListener {
            presenter.onButtonPressed(main_button_divide.text)
        }
        main_button_four.setOnClickListener {
            presenter.onButtonPressed(main_button_four.text)
        }
        main_button_five.setOnClickListener {
            presenter.onButtonPressed(main_button_five.text)
        }
        main_button_six.setOnClickListener {
            presenter.onButtonPressed(main_button_six.text)
        }
        main_button_minus.setOnClickListener {
            presenter.onButtonPressed(main_button_minus.text)
        }
        main_button_one.setOnClickListener {
            presenter.onButtonPressed(main_button_one.text)
        }
        main_button_two.setOnClickListener {
            presenter.onButtonPressed(main_button_two.text)
        }
        main_button_three.setOnClickListener {
            presenter.onButtonPressed(main_button_three.text)
        }
        main_button_plus.setOnClickListener {
            presenter.onButtonPressed(main_button_plus.text)
        }
        main_button_zero.setOnClickListener {
            presenter.onButtonPressed(main_button_zero.text)
        }
        main_button_dot.setOnClickListener {
            presenter.onButtonPressed(main_button_dot.text)
        }
        main_button_turn_to_negative.setOnClickListener {
            presenter.onButtonPressed(main_button_turn_to_negative.text)
        }
        main_button_equals.setOnClickListener {
            presenter.onButtonPressed(main_button_equals.text)
        }
    }

    override fun updateTextView(str: String) {
        main_textview_display_numbers.text = str
    }
}
