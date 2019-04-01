package com.bruno.groupradiobutton.custom.radioGroup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TableLayout
import android.widget.TableRow
import com.bruno.groupradiobutton.R
import kotlinx.android.synthetic.main.custom_radio_group.view.*
import java.util.ArrayList

class CustomRadioGroupAdapter(private val items: MutableList<CustomRadioGroupModel> = ArrayList(),
                              private val callback: CustomRadioGroup.OnItemClickListener) : androidx.recyclerview.widget.RecyclerView.Adapter<CustomRadioGroupAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_radio_group, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = items[position]
        with(holder.itemView) {
            custom_radio_group.make(position, item, callback)
        }
    }

    fun addRaioButtonWithiList(list: ArrayList<String>?, context: Context): View {
        var sizeList = list!!.size
        var i = 0
        val table = getTableRow(context)
        while (i < itemCount) {

            if (sizeList == 1) {
                 table.addView(getRadioButton(list[i], context, true))
                i += 1
                sizeList -= 1
            } else if (sizeList == 2) {
                table.addView(getRadioButton(list[i], context, true))
                table.addView(getRadioButton(list[i + 1], context, true))
                table.addView(getRadioButton("", context, false))
                i += 2
                sizeList -= 2
            } else if (sizeList > 2) {
                for (j in 0..2) {
                    table.addView(getRadioButton(list[i + j], context, true))
                    sizeList -= 1
                }
                i += 3
            }

        }
        return table
    }

    private fun getTableRowLayoutParams(): TableRow.LayoutParams {
        val tableRow = TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT)
        tableRow.weight = 1f
        return tableRow
    }

    private fun getLayoutParamTableRow(): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }

    private fun getTableRow(context: Context): TableRow {
        val table = TableRow(context)
        table.orientation = LinearLayout.HORIZONTAL
        table.layoutParams = getLayoutParamTableRow()
        table.weightSum = 3f
        return table
    }

    private fun getRadioButton(text: String, context: Context, visibility: Boolean): RadioButton {
        val radioButton = RadioButton(context)
        radioButton.layoutParams = getTableRowLayoutParams()
        radioButton.text = text
        if (!visibility)
            radioButton.visibility = View.INVISIBLE
        //radioButton.setTextAppearance(R.style.DefaultRadioButtonText)
        return radioButton
    }

    class ItemViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)
}