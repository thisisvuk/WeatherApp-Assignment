package com.assignment.weatherapp.domain.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weatherTable")
data class WeatherInfoRoom(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "time") val time: Long,
    @ColumnInfo(name = "temp") val temp: Double,
    @ColumnInfo(name = "pressure") val pressure: Double,
    @ColumnInfo(name = "clouds") val clouds: Int,
    @ColumnInfo(name = "wind_speed") val windSpeed: Double,
    @ColumnInfo(name = "weather_code") val weatherCode: Int,
    @ColumnInfo(name = "city_name") val cityName: String,
)