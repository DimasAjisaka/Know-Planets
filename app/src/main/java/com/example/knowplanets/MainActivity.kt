package com.example.knowplanets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.knowplanets.databinding.ActivityMainBinding
import com.example.knowplanets.response.PlanetResponse
import com.example.knowplanets.utils.APIService
import com.example.knowplanets.utils.MainViewModel
import com.example.knowplanets.utils.PlanetAPI
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.push.setOnClickListener {
            if (binding.planetname.text!!.isNotEmpty()){
                //get data input
                val name: String = binding.planetname.text.toString()
//                var getPlanets: PlanetResponse?=null
                mainViewModel.getPlanet(name,this)
                mainViewModel.getPlanet.observe(this){getPlanet ->
//                    getPlanets = getPlanet
                    //move
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.data,getPlanet)
                    startActivity(intent)
                }
            } else {
                binding.planetname.error = "Please Give Me the Planet's Name"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}