package com.assignment.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val CACHE_CONTROL_HEADER = "Cache-Control"
const val CACHE_CONTROL_NO_CACHE = "no-cache"

interface WeatherApi {

    @GET("forecast?appid=c11de0400e58297214115aa89b7def9f&units=metric")
    @Headers("$CACHE_CONTROL_HEADER: $CACHE_CONTROL_NO_CACHE")
    suspend fun getWeatherForecastData(
        @Query("lat") lat: Double,
        @Query("lon") long: Double
    ): WeatherDto

    @GET("weather?appid=c11de0400e58297214115aa89b7def9f&units=metric")
    @Headers("$CACHE_CONTROL_HEADER: $CACHE_CONTROL_NO_CACHE")
    suspend fun getWeatherCurrentData(
        @Query("lat") lat: Double,
        @Query("lon") long: Double
    ): CurrWeatherDataDto

    @GET("weather?appid=c11de0400e58297214115aa89b7def9f&units=metric")
    @Headers("$CACHE_CONTROL_HEADER: $CACHE_CONTROL_NO_CACHE")
    suspend fun getCityWeatherCurrentData(
        @Query("id") id: Int
    ): CurrWeatherDataDto
}