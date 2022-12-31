package com.example.knowplanets.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.knowplanets.response.PlanetResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val _getPLanet = MutableLiveData<PlanetResponse>()
    val getPlanet = _getPLanet

    fun getPlanet(name: String,context: Context){
        Log.e("name ",name)
        val search = APIService.getAPI().getPlanet(name)
        search.enqueue(object : Callback<ArrayList<PlanetResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PlanetResponse>>,
                response: Response<ArrayList<PlanetResponse>>
            ) {
                if (response.isSuccessful){
                    if (response.body() != null){
                        val data = PlanetResponse(
                            response.body()?.get(0)?.name,
                            response.body()?.get(0)?.mass,
                            response.body()?.get(0)?.radius,
                            response.body()?.get(0)?.period,
                            response.body()?.get(0)?.semi_major_axis,
                            response.body()?.get(0)?.temperature,
                            response.body()?.get(0)?.distance_light_year,
                            response.body()?.get(0)?.host_star_mass,
                            response.body()?.get(0)?.host_star_temperature
                        )
                        _getPLanet.value = data
//                        Log.e("name ","Empty")
                    } else {
                        Toast.makeText(context, "kosong", Toast.LENGTH_LONG).show()
                        Log.e("name Null","Empty")
                    }
                } else {
                    Toast.makeText(context,response.message(), Toast.LENGTH_LONG).show()
                    Log.e("name Unsuccesfull",response.message())
                }
            }

            override fun onFailure(call: Call<ArrayList<PlanetResponse>>, t: Throwable) {
                Toast.makeText(context,t.message, Toast.LENGTH_LONG).show()
                Log.e("name onFailure",t.message.toString())
            }

        })
    }
}