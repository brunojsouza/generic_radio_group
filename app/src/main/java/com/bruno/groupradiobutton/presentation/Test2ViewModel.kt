package com.bruno.groupradiobutton.presentation

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.bruno.groupradiobutton.components.SimpleRadioAdapter
import com.bruno.groupradiobutton.components.SimpleRadioView
import com.bruno.groupradiobutton.components.SimpleRadionModel
import java.util.*

class Test2ViewModel(val context: Context) {
    var adapter = ObservableField<SimpleRadioAdapter>()
    var itemSelected: Int =  -1
    var visibilityButtonAccept = ObservableBoolean(false)

    init{
        setItens()
    }

    private fun setItens() {
        adapter.set( SimpleRadioAdapter(
            Arrays.asList(
                SimpleRadionModel("1",false),
                SimpleRadionModel("2",true),
                SimpleRadionModel("3",false),
                SimpleRadionModel("4", false)
            ),
            object : SimpleRadioView.OnItemClickListener {
                override fun onItemClick(position: Int, model: SimpleRadionModel) {
                    if(!visibilityButtonAccept.get())
                        visibilityButtonAccept.set(true)

                    itemSelected = model.title.toInt()
                    Toast.makeText(
                        context,
                        "position -> " + position + " model -> " + model.title,
                        Toast.LENGTH_SHORT
                    ).show()
                    (adapter.get() as SimpleRadioAdapter).checkedItem(position)
                }
            }
        ))
    }

    fun addRadios() {
        Toast.makeText(
            context,
            "Data -> $itemSelected",Toast.LENGTH_SHORT).show()
    }
}