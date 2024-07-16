package com.example.awakemeneh.ui.restarea

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.awakemeneh.R

class DetailRest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_rest)

        val nameArea = findViewById<TextView>(R.id.namearea)
        val coordinates = findViewById<TextView>(R.id.coordinates)
        val addressArea = findViewById<TextView>(R.id.addressarea)

        val name = intent.getStringExtra("REST_AREA_NAME")
        val address = intent.getStringExtra("REST_AREA_ADDRESS")
        val coords = intent.getStringExtra("REST_AREA_COORDINATES")

        nameArea.text = name
        coordinates.text = coords
        addressArea.text = address
    }

}
