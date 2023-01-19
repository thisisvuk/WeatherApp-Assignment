package com.assignment.weatherapp.data.database

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import com.assignment.weatherapp.domain.database.AppDatabase
import com.assignment.weatherapp.domain.database.WeatherInfoRoom
import com.assignment.weatherapp.domain.util.Resource
import com.assignment.weatherapp.domain.weather.WeatherData
import com.assignment.weatherapp.domain.weather.WeatherInfo
import com.assignment.weatherapp.domain.weather.WeatherType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RoomDatabase(context: Context) {
    private val dao = AppDatabase.getInstance(context).weatherDao()

    fun insert(data: WeatherInfoRoom, lifecycleScope: LifecycleCoroutineScope) {
        lifecycleScope.launch(Dispatchers.IO) {
            WeatherInfoRoom(
                uid = data.uid,
                time = data.time,
                temp = data.temp,
                pressure = data.pressure,
                clouds = data.clouds,
                windSpeed = data.windSpeed,
                weatherCode = data.weatherCode,
                cityName = data.cityName
            ).let { dao.insertAll(it) }
        }
    }

    suspend fun get(lifecycleScope: LifecycleCoroutineScope): Resource<WeatherInfo> {
        return try {
            var result: List<WeatherInfoRoom> = emptyList()
            var resultCity: List<WeatherInfoRoom> = emptyList()
            val job = lifecycleScope.launch(Dispatchers.IO) {
                result = dao.getAll()
                resultCity = dao.getAllCity()
            }
            job.join()
            val weatherDataMap = toWeatherDataMap(result)
            val currentWeatherData = weatherDataMap[0]?.get(0)
            val currentCityWeatherData = toCityWeatherList(resultCity)
            Resource.Success(
                data = currentWeatherData?.let {
                    WeatherInfo(
                        weatherDataPerDay = weatherDataMap,
                        currentWeatherData = it,
                        cityWeatherData = currentCityWeatherData
                    )
                })
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }

    }

    private fun toCityWeatherList(resultCity: List<WeatherInfoRoom>): List<WeatherData> {
        val list: ArrayList<WeatherData> = ArrayList()
        List(resultCity.size) { index ->
            val time =
                DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(resultCity[index].time))
            list.add(
                WeatherData(
                    time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                    temperatureCelsius = resultCity[index].temp,
                    pressure = resultCity[index].pressure,
                    clouds = resultCity[index].clouds,
                    windSpeed = resultCity[index].windSpeed,
                    weatherType = WeatherType.fromWMO(resultCity[index].weatherCode),
                    cityName = resultCity[index].cityName
                )
            )
        }
        return list
    }

    private data class IndexedWeatherData(
        val index: Int,
        val data: WeatherData
    )

    private fun toWeatherDataMap(
        result: List<WeatherInfoRoom>
    ): Map<Int, List<WeatherData>> {

        return List(result.size) { index ->
            val temperature = result[index].temp
            val pressure = result[index].pressure
            val weatherCode = result[index].weatherCode
            val windSpeed = result[index].windSpeed
            val clouds = result[index].clouds
            val cityName = result[index].cityName
            val time =
                DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(result[index].time))

            IndexedWeatherData(
                index = index,
                data = WeatherData(
                    time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                    temperatureCelsius = temperature,
                    pressure = pressure,
                    clouds = clouds,
                    windSpeed = windSpeed,
                    weatherType = WeatherType.fromWMO(weatherCode),
                    cityName = cityName
                )
            )

        }.groupBy {
            it.index / 9
        }.mapValues { it ->
            it.value.map { it.data }
        }
    }
}