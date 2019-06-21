package com.bruno.groupradiobutton.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bruno.groupradiobutton.R
import com.bruno.groupradiobutton.components.SimpleRadioAdapter
import com.bruno.groupradiobutton.components.SimpleRadioView
import com.bruno.groupradiobutton.components.SimpleRadionModel
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.activity_teste.*
import java.util.*


class TesteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        val layoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER

        }

        recycler.layoutManager = layoutManager

        recycler.adapter = SimpleRadioAdapter(
            Arrays.asList(
                SimpleRadionModel("120"),
                SimpleRadionModel("180"),
                SimpleRadionModel("240"),
                SimpleRadionModel("300"),
                SimpleRadionModel("360")
            ),
            object : SimpleRadioView.OnItemClickListener {
                override fun onItemClick(position: Int, model: SimpleRadionModel) {
                    Toast.makeText(
                        applicationContext,
                        "position -> " + position + " model -> " + model.title,
                        Toast.LENGTH_SHORT
                    ).show()

                    (recycler.adapter as SimpleRadioAdapter).checkedItem(position)
                }
            }
        )
    }
}
