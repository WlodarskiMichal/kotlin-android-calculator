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
            presenter.clearViewButtonPressed()
        }
        main_button_percent.setOnClickListener {
            presenter.operationPercentButtonPressed()
        }
        main_button_square_root.setOnClickListener {
            presenter.squareRootButtonPressed()
        }
        main_button_multiply.setOnClickListener {
            presenter.operationButtonPressed("×")
        }
        main_button_seven.setOnClickListener {
            presenter.numberButtonPressed("7")
        }
        main_button_eight.setOnClickListener {
            presenter.numberButtonPressed("8")
        }
        main_button_nine.setOnClickListener {
            presenter.numberButtonPressed("9")
        }
        main_button_divide.setOnClickListener {
            presenter.operationButtonPressed("÷")
        }
        main_button_four.setOnClickListener {
            presenter.numberButtonPressed("4")
        }
        main_button_five.setOnClickListener {
            presenter.numberButtonPressed("5")
        }
        main_button_six.setOnClickListener {
            presenter.numberButtonPressed("6")
        }
        main_button_minus.setOnClickListener {
            presenter.operationButtonPressed("−")
        }
        main_button_one.setOnClickListener {
            presenter.numberButtonPressed("1")
        }
        main_button_two.setOnClickListener {
            presenter.numberButtonPressed("2")
        }
        main_button_three.setOnClickListener {
            presenter.numberButtonPressed("3")
        }
        main_button_plus.setOnClickListener {
            presenter.operationButtonPressed("+")
        }
        main_button_zero.setOnClickListener {
            presenter.numberButtonPressed("0")
        }
        main_button_dot.setOnClickListener {
            presenter.numberButtonPressed(".")
        }
        main_button_turn_to_negative.setOnClickListener {
            presenter.numberButtonPressed("-")
        }
        main_button_equals.setOnClickListener {
            presenter.equalsButtonPressed()
        }
    }

    override fun updateTextView(str: String) {
        main_textview_display_numbers.text = str
    }
}
