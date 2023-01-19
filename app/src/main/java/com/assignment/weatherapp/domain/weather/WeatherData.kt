package com.assignment.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val clouds: Int,
    val windSpeed: Double,
    val weatherType: WeatherType,
    val cityName: String
)
