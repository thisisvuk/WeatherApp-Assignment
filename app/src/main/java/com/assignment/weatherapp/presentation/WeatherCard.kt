package com.assignment.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.assignment.weatherapp.R
import com.assignment.weatherapp.presentation.ui.theme.dimensions
import com.assignment.weatherapp.presentation.ui.theme.type
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(MaterialTheme.dimensions.medium),
            modifier = modifier.padding(MaterialTheme.dimensions.large)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.dimensions.large),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = data.cityName,
                    style = MaterialTheme.type.bodyLarge,
                    color = Color.White, fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
                Text(
                    text =
                    data.time.format(
                        DateTimeFormatter.ofPattern("hh:mm a")
                    ),
                    style = MaterialTheme.type.bodyLarge,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(MaterialTheme.dimensions.xxxxLarge)
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
                Text(
                    text = "${data.temperatureCelsius}°C",
                    style = MaterialTheme.type.displayLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
                Text(
                    text = data.weatherType.weatherDesc,
                    style = MaterialTheme.type.bodyLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimensions.xLarge))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = stringResource(R.string.unit_hpa),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        iconTint = Color.White,
                        textStyle = MaterialTheme.type.bodyMedium
                    )
                    WeatherDataDisplay(
                        value = data.clouds,
                        unit = stringResource(R.string.unit_percentage),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_clouds),
                        iconTint = Color.White,
                        textStyle = MaterialTheme.type.bodyMedium
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = stringResource(R.string.unit_kmh),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTint = Color.White,
                        textStyle = MaterialTheme.type.bodyMedium
                    )
                }
            }
        }
    }
}