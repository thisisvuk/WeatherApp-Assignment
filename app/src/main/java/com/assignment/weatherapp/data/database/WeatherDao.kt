package com.assignment.weatherapp.data.database

import androidx.room.*
import com.assignment.weatherapp.domain.database.WeatherInfoRoom

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weatherTable")
    fun getAll(): List<WeatherInfoRoom>

    @Query("SELECT * FROM weatherTable WHERE uid>100")
    fun getAllCity(): List<WeatherInfoRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg weather: WeatherInfoRoom)

    @Delete
    fun delete(user: WeatherInfoRoom)
}