package com.example.awakemeneh.ui.alertlevel

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.awakemeneh.R
import com.example.awakemeneh.databinding.ActivityAlertLevelBinding
import com.example.awakemeneh.databinding.ActivityCameraLiveBinding

class AlertLevel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_level)

        var binding = ActivityAlertLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set click listener for back icon
        val backIcon = binding.root.findViewById<ImageView>(R.id.backalert)
        backIcon.setOnClickListener {
            // Finish the current activity and go back to the previous one
            finish()
        }
    }
}