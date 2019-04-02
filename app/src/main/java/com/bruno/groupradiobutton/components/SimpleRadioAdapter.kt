package com.bruno.groupradiobutton.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bruno.groupradiobutton.R
import kotlinx.android.synthetic.main.item_custom_radio_button.view.*
import java.util.ArrayList

class SimpleRadioAdapter
constructor(
    private val items: MutableList<SimpleRadionModel> = ArrayList(),
    private val callback: SimpleRadioView.OnItemClickListener
) : RecyclerView.Adapter<SimpleRadioAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_radio_button, parent, false);
        return ItemViewHolder(view); }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = items[position];
        with(holder.itemView) {
            simpleRadioView.make(position, item, callback)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)
}