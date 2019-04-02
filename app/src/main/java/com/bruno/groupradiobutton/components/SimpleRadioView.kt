package com.bruno.groupradiobutton.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatRadioButton
import com.bruno.groupradiobutton.R
import kotlinx.android.synthetic.main.simple_radio_button.view.*

class SimpleRadioView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attributeSet, defStyle) {

    var callback: OnItemClickListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.simple_radio_button, this, true)

    }

    fun make(position: Int, simpleRadionModel: SimpleRadionModel, callback: OnItemClickListener) {
        radio.text = simpleRadionModel.title

        configureAction(callback)

        radio.setOnClickListener {
            callback.onItemClick(position, simpleRadionModel)


        }

    }

    private fun configureAction(callback: OnItemClickListener) {
        this.callback = callback
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, model: SimpleRadionModel)
    }

}