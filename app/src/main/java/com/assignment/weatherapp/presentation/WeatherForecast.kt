package com.assignment.weatherapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.assignment.weatherapp.R
import com.assignment.weatherapp.presentation.ui.theme.dimensions
import com.assignment.weatherapp.presentation.ui.theme.type

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimensions.large)
        ) {
            Text(
                text = stringResource(R.string.forecast),
                style = MaterialTheme.type.headlineMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = Modifier
                            .padding(horizontal = MaterialTheme.dimensions.large)
                    )
                }
            })
        }
    }
}