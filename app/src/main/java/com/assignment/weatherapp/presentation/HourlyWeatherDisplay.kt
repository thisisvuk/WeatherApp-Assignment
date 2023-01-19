package com.assignment.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.assignment.weatherapp.domain.weather.WeatherData
import com.assignment.weatherapp.presentation.ui.theme.dimensions
import com.assignment.weatherapp.presentation.ui.theme.type
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("hh:mm a")
        )
    }
    val formattedDay = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("E")
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formattedDay,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            style = MaterialTheme.type.bodyMedium
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.extraSmall))
        Text(
            text = formattedTime,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.type.bodyMedium
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(MaterialTheme.dimensions.xxLarge)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))

        Text(
            text = "${weatherData.temperatureCelsius.roundToInt()}°C",
            color = textColor,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.type.bodyMedium
        )
    }
}