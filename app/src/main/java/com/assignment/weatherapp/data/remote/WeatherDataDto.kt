package com.assignment.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val dt: Long,
    @field:Json(name = "main") val temperatures: Main,
    @field:Json(name = "weather") val weatherCodes: List<Weather>,
    @field:Json(name = "clouds") val clouds: Clouds,
    @field:Json(name = "wind") val windSpeeds: Wind
)