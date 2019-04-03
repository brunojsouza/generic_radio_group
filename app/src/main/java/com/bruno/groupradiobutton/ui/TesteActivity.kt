package com.bruno.groupradiobutton.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bruno.groupradiobutton.R
import com.bruno.groupradiobutton.components.SimpleRadioAdapter
import com.bruno.groupradiobutton.components.SimpleRadioView
import com.bruno.groupradiobutton.components.SimpleRadionModel
import kotlinx.android.synthetic.main.activity_teste.*
import java.util.*

class TesteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        recycler.adapter = SimpleRadioAdapter(
            Arrays.asList(
                SimpleRadionModel("Radio 1"),
                SimpleRadionModel("Radio 2"),
                SimpleRadionModel("Radio 3"),
                SimpleRadionModel("Radio 4"),
                SimpleRadionModel("Radio 5"),
                SimpleRadionModel("Radio 6")
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
