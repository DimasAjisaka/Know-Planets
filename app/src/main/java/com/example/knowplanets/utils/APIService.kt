package com.example.knowplanets.utils

import com.example.knowplanets.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object APIService {
    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder().baseUrl(BuildConfig.URL).addConverterFactory(GsonConverterFactory.create())
    private val retrofit: Retrofit = retrofitBuilder.build()

    fun getAPI(): PlanetAPI = retrofit.create(PlanetAPI::class.java)
}