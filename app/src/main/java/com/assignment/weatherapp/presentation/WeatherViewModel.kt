package com.assignment.weatherapp.presentation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.weatherapp.R
import com.assignment.weatherapp.data.database.RoomDatabase
import com.assignment.weatherapp.domain.location.LocationTracker
import com.assignment.weatherapp.domain.repository.WeatherRepository
import com.assignment.weatherapp.domain.util.Resource
import com.assignment.weatherapp.domain.weather.WeatherData
import com.assignment.weatherapp.domain.weather.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository, private val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo(context: Context, lifecycleScope: LifecycleCoroutineScope) {
        viewModelScope.launch(Dispatchers.IO) {
            state = state.copy(
                isLoading = true, error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                state = when (val resultCurrent = repository.getWeatherCurrentData(
                    location.latitude, location.longitude, context, lifecycleScope
                )) {
                    is Resource.Success -> {
                        when (val resultForecast = repository.getWeatherForecastData(
                            location.latitude, location.longitude, context, lifecycleScope
                        )) {
                            is Resource.Success -> {
                                val cityWeatherList: ArrayList<WeatherData> = ArrayList()
                                val cities =
                                    listOf(5128581, 1880252, 1275339, 1273294, 2147714, 2158177)
                                List(cities.size) { index ->
                                    when (val resultCity = repository.getCityWeatherCurrentData(
                                        cities[index], context, lifecycleScope
                                    )) {
                                        is Resource.Success -> {
                                            resultCity.data?.let { cityWeatherList.add(it) }
                                        }
                                        is Resource.Error -> {
                                            state.copy(
                                                weatherInfo = null,
                                                isLoading = false,
                                                error = resultCurrent.message
                                            )
                                        }
                                    }
                                }
                                state.copy(
                                    weatherInfo = WeatherInfo(
                                        currentWeatherData = resultCurrent.data,
                                        weatherDataPerDay = resultForecast.data,
                                        cityWeatherData = cityWeatherList
                                    ), isLoading = false, error = null
                                )
                            }
                            is Resource.Error -> {
                                state.copy(
                                    weatherInfo = null,
                                    isLoading = false,
                                    error = resultCurrent.message
                                )
                            }
                        }

                    }
                    is Resource.Error -> {
                        state.copy(
                            weatherInfo = null, isLoading = false, error = resultCurrent.message
                        )
                    }
                }
            } ?: kotlin.run {
                state.copy(
                    weatherInfo = null,
                    isLoading = false,
                    error = context.getString(R.string.gps_error)
                )
            }
        }
    }

    fun loadWeatherInfoLocal(context: Context, lifecycleScope: LifecycleCoroutineScope) {
        viewModelScope.launch(Dispatchers.IO) {
            state = state.copy(
                isLoading = true, error = null
            )
            state = when (val result = RoomDatabase(context).get(lifecycleScope)) {
                is Resource.Success -> {
                    state.copy(
                        weatherInfo = result.data, isLoading = false, error = null
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        weatherInfo = null, isLoading = false, error = result.message
                    )
                }
            }
        }
    }

}