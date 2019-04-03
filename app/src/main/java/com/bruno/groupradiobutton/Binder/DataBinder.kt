package com.bruno.groupradiobutton.Binder
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

 class DataBinder {

    @BindingAdapter("setLayout")
    fun setLayout(view: RecyclerView, numberColuns: Int) {
            view.layoutManager = androidx.recyclerview.widget.GridLayoutManager(view.context, numberColuns)
    }
}