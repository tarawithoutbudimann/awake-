package com.example.awakemeneh.ui.funfact

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.awakemeneh.R
import com.example.awakemeneh.databinding.ActivityCameraLiveBinding
import com.example.awakemeneh.databinding.ActivityFaktaUnikBinding

class FaktaUnik : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fakta_unik)

        var binding = ActivityFaktaUnikBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set click listener for back icon
        val backIcon = binding.root.findViewById<ImageView>(R.id.backfakta)
        backIcon.setOnClickListener {
            // Finish the current activity and go back to the previous one
            finish()
        }
    }
}