package com.example.awakemeneh.ui.restarea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.awakemeneh.R
import com.example.awakemeneh.databinding.ActivityRestAreaSearchBinding
import com.example.awakemeneh.ui.adapter.RestAdapter
import com.example.awakemeneh.ui.data.RestArea
import android.widget.ImageView
import com.example.awakemeneh.ui.home.HomeFragment

class RestAreaSearch : AppCompatActivity() {

    private lateinit var binding: ActivityRestAreaSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestAreaSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.recyclerViewrest
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cardList1 = listOf(
            RestArea(R.drawable.restarea, "Rest Area 67", "Sagan, Caturtunggal", "-1093848493"),
            RestArea(R.drawable.restarea, "Rest Area 89", "Sekip", "10358945839834.0"),
            RestArea(R.drawable.restarea, "Rest Area 9", "Pogung", "0919282929292920"),
            RestArea(R.drawable.restarea, "Rest Area 79", "Klebengan", "9282929292920"),
            RestArea(R.drawable.restarea, "Rest Area 09", "Someplace", "1234567890")
        )

        val cardAdapter = RestAdapter(cardList1, this)
        recyclerView.adapter = cardAdapter

        // Set click listener for back icon
        val backIcon = binding.root.findViewById<ImageView>(R.id.backIcon)
        backIcon.setOnClickListener {
            // Finish the current activity and go back to the previous one
            finish()
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // Handle back press to go to Home fragment
        val intent = Intent(this, HomeFragment::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}
