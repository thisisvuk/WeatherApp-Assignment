package com.assignment.weatherapp.presentation

import androidx.compose.foundation.layout.*
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
fun CityView(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.cityWeatherData?.let {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.dimensions.large,
                    vertical = MaterialTheme.dimensions.medium
                )
        ) {
            Text(
                text = stringResource(R.string.weather_of_city),
                style = MaterialTheme.type.headlineMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
            List(it.size) { index ->
                CityCards(
                    data = it[index],
                    image = it[index].weatherType.iconRes,
                    modifier = Modifier.padding(vertical = MaterialTheme.dimensions.large)
                )
            }
        }

    }
}
