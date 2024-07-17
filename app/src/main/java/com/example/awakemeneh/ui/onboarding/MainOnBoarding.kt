package com.example.awakemeneh.ui.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.awakemeneh.MainActivity
import com.example.awakemeneh.R
import com.example.awakemeneh.ui.adapter.OnBoardingAdap

class MainOnBoarding : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: OnBoardingAdap
    private lateinit var buttonNext: Button
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if onboarding is already completed
        sharedPref = getSharedPreferences("onboarding", MODE_PRIVATE)
        if (sharedPref.getBoolean("onboardingCompleted", false)) {
            finishOnboarding()
            return
        }

        setContentView(R.layout.activity_main_on_boarding)

        // Setup ViewPager2 for onboarding slides
        val layouts = listOf(
            R.layout.slide_1,
            R.layout.slide_2,
            R.layout.slide_3
        )

        viewPager = findViewById(R.id.viewPager)
        adapter = OnBoardingAdap(layouts)
        viewPager.adapter = adapter

        buttonNext = findViewById(R.id.button_next)
        buttonNext.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem + 1 < adapter.itemCount) {
                viewPager.currentItem = currentItem + 1
            } else {
                // Save the state in SharedPreferences
                with(sharedPref.edit()) {
                    putBoolean("onboardingCompleted", true)
                    apply()
                }
                finishOnboarding()
            }
        }

        // Set OnPageChangeCallback to detect when the last slide is reached
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == layouts.size - 1) {
                    // Save the state in SharedPreferences
                    with(sharedPref.edit()) {
                        putBoolean("onboardingCompleted", true)
                        apply()
                    }
                    finishOnboarding()
                }
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun finishOnboarding() {
        // Start MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        // Finish the onboarding activity so user can't go back to it
        finish()
    }
}
