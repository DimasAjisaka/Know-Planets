package com.example.knowplanets.utils

import com.example.knowplanets.BuildConfig
import com.example.knowplanets.response.PlanetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PlanetAPI {
    //(header)
    @Headers("X-RapidAPI-Key: ${BuildConfig.KEY}","X-RapidAPI-Host: ${BuildConfig.HOST}")
    //method setelah com
    @GET ("v1/planets")
    fun getPlanet (@Query("name")name:String?): Call<ArrayList<PlanetResponse>>
}