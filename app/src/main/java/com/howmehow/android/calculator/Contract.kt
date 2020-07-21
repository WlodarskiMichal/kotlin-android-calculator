package com.howmehow.android.calculator

import android.widget.Button

interface Contract {

    interface View{
        fun updateTextView(str : String)
    }

    interface Presenter{
        fun init(view: View)
        fun onButtonPressed(pressedButton : Button)
    }
}
