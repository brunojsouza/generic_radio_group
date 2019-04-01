package com.bruno.groupradiobutton.custom.radioGroup

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bruno.groupradiobutton.R
class CustomRadioGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var callback: OnItemClickListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_radio_group, this)
    }

    fun make(position: Int, model: CustomRadioGroupModel?, callback: OnItemClickListener) {
        if(model != null) {

            }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, model: CustomRadioGroupModel)
    }
}