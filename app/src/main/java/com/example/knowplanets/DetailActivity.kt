package com.example.knowplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowplanets.databinding.ActivityDetailBinding
import com.example.knowplanets.response.PlanetResponse

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //get data from api
        val rawData = intent.getParcelableExtra<PlanetResponse>(data) as PlanetResponse
        if (rawData.name?.lowercase().equals("mercury")){
            binding.pict.setImageResource(R.drawable.mercury)
        } else if (rawData.name?.lowercase().equals("venus")){
            binding.pict.setImageResource(R.drawable.venus)
        } else if (rawData.name?.lowercase().equals("earth")){
            binding.pict.setImageResource(R.drawable.earth)
        } else if (rawData.name?.lowercase().equals("mars")){
            binding.pict.setImageResource(R.drawable.mars)
        } else if (rawData.name?.lowercase().equals("jupiter")){
            binding.pict.setImageResource(R.drawable.jupiter)
        } else if (rawData.name?.lowercase().equals("saturnus")){
            binding.pict.setImageResource(R.drawable.saturnus)
        } else if (rawData.name?.lowercase().equals("uranus")){
            binding.pict.setImageResource(R.drawable.uranus)
        } else if (rawData.name?.lowercase().equals("neptunus")){
            binding.pict.setImageResource(R.drawable.neptunus)
        }
        binding.planame.text = rawData.name
        binding.massdesc.text = rawData.mass
        binding.radesc.text = rawData.radius
        binding.perdesc.text = rawData.period
        binding.axdesc.text = rawData.semi_major_axis
        binding.tempdesc.text = rawData.temperature
        binding.disdesc.text = rawData.distance_light_year
        binding.hmdesc.text = rawData.host_star_mass
        binding.htdesc.text = rawData.host_star_temperature
        binding.back.setOnClickListener { finish() }
    }

    companion object{
        const val data = "data"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}