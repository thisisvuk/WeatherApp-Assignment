package com.assignment.weatherapp.data.repository

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import com.assignment.weatherapp.R
import com.assignment.weatherapp.data.mappers.toCityWeatherInfo
import com.assignment.weatherapp.data.mappers.toWeatherDataMap
import com.assignment.weatherapp.data.mappers.toWeatherInfo
import com.assignment.weatherapp.data.remote.WeatherApi
import com.assignment.weatherapp.domain.repository.WeatherRepository
import com.assignment.weatherapp.domain.util.Resource
import com.assignment.weatherapp.domain.weather.WeatherData
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherForecastData(
        lat: Double,
        long: Double,
        context: Context,
        lifecycleScope: LifecycleCoroutineScope
    ): Resource<Map<Int, List<WeatherData>>> {
        return try {
            Resource.Success(
                data = api.getWeatherForecastData(
                    lat = lat,
                    long = long
                ).toWeatherDataMap(context, lifecycleScope)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: context.getString(R.string.error_message))
        }
    }

    override suspend fun getWeatherCurrentData(
        lat: Double,
        long: Double,
        context: Context,
        lifecycleScope: LifecycleCoroutineScope
    ): Resource<WeatherData> {
        return try {
            Resource.Success(
                data = api.getWeatherCurrentData(
                    lat = lat,
                    long = long
                ).toWeatherInfo(context, lifecycleScope)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: context.getString(R.string.error_message))
        }
    }

    override suspend fun getCityWeatherCurrentData(
        id: Int,
        context: Context,
        lifecycleScope: LifecycleCoroutineScope
    ): Resource<WeatherData> {
        return try {
            Resource.Success(
                data = api.getCityWeatherCurrentData(
                    id = id
                ).toCityWeatherInfo(context, lifecycleScope)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: context.getString(R.string.error_message))
        }
    }
}