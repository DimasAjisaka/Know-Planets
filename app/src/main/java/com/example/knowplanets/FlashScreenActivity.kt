package com.example.knowplanets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.knowplanets.databinding.ActivityFlashScreenBinding

class FlashScreenActivity : AppCompatActivity() {
    private var _binding: ActivityFlashScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFlashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //animation
        val splashDuration = 2000

        binding.logo.alpha = 0f
        binding.logodesc.alpha = 0f
        binding.logo.translationZ = 800f
        binding.logo.translationY = 30f
        binding.logodesc.translationZ = -800f
        binding.logodesc.translationY = -30f
        binding.logo.animate().alpha(1f).translationY(0f).setStartDelay(500).setDuration(500).start()
        binding.logodesc.animate().alpha(1f).translationY(0f).setStartDelay(500).setDuration(500).start()

        //next
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@FlashScreenActivity, MainActivity::class.java))
            finish()
        }, splashDuration.toLong())
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}