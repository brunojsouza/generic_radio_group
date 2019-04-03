package com.bruno.groupradiobutton.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.bruno.groupradiobutton.R
import com.bruno.groupradiobutton.presentation.Test2ViewModel
import kotlinx.android.synthetic.main.activity_test2ctivity.*

class Test2ctivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2ctivity)
        var mainBinding: com.bruno.groupradiobutton.databinding.ActivityTest2ctivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_test2ctivity)
        var mainViewModel =  Test2ViewModel(this)
        mainBinding.viewModel = mainViewModel

        setLayoutManagerRecycler()
    }

    private fun setLayoutManagerRecycler() {
        recycler_dateExpiry.layoutManager = GridLayoutManager(this, 3)
    }
}
