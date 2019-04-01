package com.bruno.groupradiobutton.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bruno.groupradiobutton.R
import com.bruno.groupradiobutton.presentation.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mainBinding: com.bruno.groupradiobutton.databinding.ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var mainViewModel =  MainActivityViewModel()
        mainBinding.viewModel = mainViewModel
    }
}
