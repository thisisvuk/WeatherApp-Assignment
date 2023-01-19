package com.assignment.weatherapp.domain.repository

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import com.assignment.weatherapp.domain.util.Resource
import com.assignment.weatherapp.domain.weather.WeatherData

interface WeatherRepository {
    suspend fun getWeatherForecastData(
        lat: Double,
        long: Double,
        context: Context,
        lifecycleScope: LifecycleCoroutineScope
    ): Resource<Map<Int, List<WeatherData>>>

    suspend fun getWeatherCurrentData(
        lat: Double,
        long: Double,
        context: Context,
        lifecycleScope: LifecycleCoroutineScope
    ): Resource<WeatherData>

    suspend fun getCityWeatherCurrentData(
        id: Int,
        context: Context,
        lifecycleScope: LifecycleCoroutineScope
    ): Resource<WeatherData>
}