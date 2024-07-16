package com.example.awakemeneh.ui.restarea

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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
        val backIcondetail = findViewById<ImageView>(R.id.backIcon1)

        val name = intent.getStringExtra("REST_AREA_NAME")
        val address = intent.getStringExtra("REST_AREA_ADDRESS")
        val coords = intent.getStringExtra("REST_AREA_COORDINATES")

        nameArea.text = name
        coordinates.text = coords
        addressArea.text = address

        // Set click listener for back icon
        backIcondetail.setOnClickListener {
            // Start RestAreaSearch activity with FLAG_ACTIVITY_CLEAR_TOP
            val intent = Intent(this, RestAreaSearch::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }
}
