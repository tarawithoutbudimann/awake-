package com.example.awakemeneh.ui.livecam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.awakemeneh.R
import com.example.awakemeneh.databinding.ActivityCameraLiveBinding
import com.example.awakemeneh.databinding.ActivityRestAreaSearchBinding
import com.example.awakemeneh.ui.home.HomeFragment

class CameraLive : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_live)

        var binding = ActivityCameraLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set click listener for back icon
        val backIcon = binding.root.findViewById<ImageView>(R.id.backcamera)
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