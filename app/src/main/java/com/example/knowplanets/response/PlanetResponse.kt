package com.example.knowplanets.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetResponse(
    //sesuaikan dengan api variabel (response body)
    @field: SerializedName("name")
    val name: String?,
    @field: SerializedName("mass")
    val mass: String?,
    @field: SerializedName("radius")
    val radius: String?,
    @field: SerializedName("period")
    val period: String?,
    @field: SerializedName("semi_major_axis")
    val semi_major_axis: String?,
    @field: SerializedName("temperature")
    val temperature: String?,
    @field: SerializedName("distance_light_year")
    val distance_light_year: String?,
    @field: SerializedName("host_star_mass")
    val host_star_mass: String?,
    @field: SerializedName("host_star_temperature")
    val host_star_temperature: String?
) : Parcelable
