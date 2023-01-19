package com.assignment.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "list")
    val weatherData: List<WeatherDataDto>,
    @field:Json(name = "city")
    val cityData: City
)
