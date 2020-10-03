package com.howmehow.android.calculator

import android.widget.Button

interface Contract {

    interface View{
        fun updateTextView(str : String)
        fun updateSecondTextView(str : String)
    }

    interface Presenter{
        fun init(view: View)
        fun clearViewButtonPressed()
        fun operationPercentButtonPressed()
        fun operationButtonPressed(stringFromPressedOperationButton: String)
        fun numberButtonPressed(stringFromPressedNumberButton: String)
        fun squareRootButtonPressed()
        fun equalsButtonPressed()
    }
}
