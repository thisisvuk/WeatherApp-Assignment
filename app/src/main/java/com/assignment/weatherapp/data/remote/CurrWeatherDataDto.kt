package com.assignment.weatherapp.data.remote

import com.squareup.moshi.Json

data class CurrWeatherDataDto(
    val dt: Long,
    @field:Json(name = "main") val temperatures: Main,
    @field:Json(name = "weather") val weatherCodes: List<Weather>,
    @field:Json(name = "clouds") val clouds: Clouds,
    @field:Json(name = "wind") val windSpeeds: Wind,
    @field:Json(name = "name") val cityName: String,
    @field:Json(name = "sys") val sys: Sys,
    @field:Json(name = "timezone") val timeZone: Int,
    @field:Json(name = "id") val id: Int
)