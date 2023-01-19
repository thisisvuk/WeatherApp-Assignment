package com.assignment.weatherapp.domain.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>?,
    val currentWeatherData: WeatherData?,
    val cityWeatherData: List<WeatherData>?
)
