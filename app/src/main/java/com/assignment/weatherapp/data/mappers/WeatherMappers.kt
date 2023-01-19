package com.assignment.weatherapp.data.mappers

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import com.assignment.weatherapp.data.database.RoomDatabase
import com.assignment.weatherapp.data.remote.CurrWeatherDataDto
import com.assignment.weatherapp.data.remote.WeatherDto
import com.assignment.weatherapp.domain.database.WeatherInfoRoom
import com.assignment.weatherapp.domain.weather.WeatherData
import com.assignment.weatherapp.domain.weather.WeatherType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDto.toWeatherDataMap(
    mainActivity: Context,
    lifecycleScope: LifecycleCoroutineScope
): Map<Int, List<WeatherData>> {

    return List(weatherData.size) { index ->
        val temperature = weatherData[index].temperatures.temp
        val pressure = weatherData[index].temperatures.pressure
        var weatherCode = weatherData[index].weatherCodes[0].id
        val windSpeed = weatherData[index].windSpeeds.speed
        val clouds = weatherData[index].clouds.all
        val time = LocalDateTime.parse(
            DateTimeFormatter.ISO_INSTANT
                .format(java.time.Instant.ofEpochSecond(weatherData[index].dt + cityData.timezone)),
            DateTimeFormatter.ISO_DATE_TIME
        )
        val hour = time.format(DateTimeFormatter.ofPattern("H")).toInt()
        if ((hour < 6 || hour > 18) && (weatherCode in 800..801 || (weatherCode in 500..504))) {
            weatherCode += 1000
        }
        val cityName = "${cityData.name}, ${cityData.country}"
        lifecycleScope.launch(Dispatchers.IO) {
            RoomDatabase(mainActivity).insert(
                WeatherInfoRoom(
                    uid = index + 1,
                    time = weatherData[index].dt + cityData.timezone,
                    temp = temperature,
                    pressure = pressure,
                    clouds = clouds,
                    windSpeed = windSpeed,
                    weatherCode = weatherCode,
                    cityName = cityName
                ), lifecycleScope
            )
        }
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = time,
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

fun CurrWeatherDataDto.toWeatherInfo(
    mainActivity: Context,
    lifecycleScope: LifecycleCoroutineScope
): WeatherData {
    val time = LocalDateTime.parse(
        DateTimeFormatter.ISO_INSTANT
            .format(java.time.Instant.ofEpochSecond(dt + timeZone)), DateTimeFormatter.ISO_DATE_TIME
    )
    val hour = time.format(DateTimeFormatter.ofPattern("H")).toInt()
    var weatherCode = weatherCodes[0].id
    if ((hour < 6 || hour > 18) && (weatherCode in 800..801 || (weatherCode in 500..504))) {
        weatherCode += 1000
    }
    lifecycleScope.launch(Dispatchers.IO) {
        RoomDatabase(mainActivity).insert(
            WeatherInfoRoom(
                uid = 0,
                time = dt + timeZone,
                temp = temperatures.temp,
                pressure = temperatures.pressure,
                clouds = clouds.all,
                windSpeed = windSpeeds.speed,
                weatherCode = weatherCode,
                cityName = cityName + ", " + sys.country
            ), lifecycleScope
        )
    }
    return WeatherData(
        time = time,
        temperatureCelsius = temperatures.temp,
        pressure = temperatures.pressure,
        clouds = clouds.all,
        windSpeed = windSpeeds.speed,
        weatherType = WeatherType.fromWMO(weatherCode),
        cityName = cityName + ", " + sys.country
    )
}

fun CurrWeatherDataDto.toCityWeatherInfo(
    mainActivity: Context,
    lifecycleScope: LifecycleCoroutineScope
): WeatherData {
    val time = LocalDateTime.parse(
        DateTimeFormatter.ISO_INSTANT
            .format(java.time.Instant.ofEpochSecond(dt + timeZone)), DateTimeFormatter.ISO_DATE_TIME
    )
    val hour = time.format(DateTimeFormatter.ofPattern("H")).toInt()
    var weatherCode = weatherCodes[0].id
    if ((hour < 6 || hour > 18) && (weatherCode in 800..801 || (weatherCode in 500..504))) {
        weatherCode += 1000
    }
    lifecycleScope.launch(Dispatchers.IO) {
        RoomDatabase(mainActivity).insert(
            WeatherInfoRoom(
                uid = id,
                time = dt + timeZone,
                temp = temperatures.temp,
                pressure = temperatures.pressure,
                clouds = clouds.all,
                windSpeed = windSpeeds.speed,
                weatherCode = weatherCode,
                cityName = cityName + ", " + sys.country
            ), lifecycleScope
        )
    }
    return WeatherData(
        time = time,
        temperatureCelsius = temperatures.temp,
        pressure = temperatures.pressure,
        clouds = clouds.all,
        windSpeed = windSpeeds.speed,
        weatherType = WeatherType.fromWMO(weatherCode),
        cityName = cityName + ", " + sys.country
    )
}


