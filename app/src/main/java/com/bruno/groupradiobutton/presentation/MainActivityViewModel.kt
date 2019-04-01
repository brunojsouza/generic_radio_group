package com.bruno.groupradiobutton.presentation

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.bruno.groupradiobutton.R
import com.bruno.groupradiobutton.custom.InterRadioGroup
import com.bruno.groupradiobutton.custom.radioGroup.CustomRadioGroup
import com.bruno.groupradiobutton.custom.radioGroup.CustomRadioGroupAdapter
import com.bruno.groupradiobutton.custom.radioGroup.CustomRadioGroupModel

class MainActivityViewModel {
    var itemSelected = ObservableBoolean(false)
    var list = ObservableField<ArrayList<String>>()
    val adapter = ObservableField<CustomRadioGroupAdapter>()
    lateinit var adapterR: CustomRadioGroupAdapter

    init {
        list.set(getDateList())
        //setList()
    }

    private fun setList() {
        adapter.set(adapterR.apply {
            getDateList()
        })
    }

    fun addRadios(v: View) {
        val group: InterRadioGroup = (v.parent as ViewGroup).findViewById(R.id.expiry_dates)
        group.addRaioButtonWithiList(getDateList(), v.context)
    }

    private fun getDateList(): ArrayList<String> {
        val dateList = ArrayList<String>()
        for (i in 1 until 13) {
            dateList.add("Radio $i")
        }
        return dateList
    }

    private fun setAdapter(): CustomRadioGroupAdapter {
            return  CustomRadioGroupAdapter(getDateListModel(),
                object: CustomRadioGroup.OnItemClickListener{
                    override fun onItemClick(position: Int, model: CustomRadioGroupModel) {
                        itemSelected.set(true)
                    }
                })
    }

    private fun getDateListModel(): ArrayList<CustomRadioGroupModel> {
        val dateList = ArrayList<CustomRadioGroupModel>()
        for (i in 1 until 6) {
            dateList.add(CustomRadioGroupModel("Radio $i"))
        }
        return dateList
    }
}