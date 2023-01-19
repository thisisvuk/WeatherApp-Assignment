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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import com.assignment.weatherapp.R
import com.assignment.weatherapp.domain.weather.WeatherData
import com.assignment.weatherapp.presentation.ui.theme.CardWhite
import com.assignment.weatherapp.presentation.ui.theme.dimensions
import com.assignment.weatherapp.presentation.ui.theme.type
import kotlin.math.roundToInt

@Composable
fun CityCards(
    modifier: Modifier,
    textColor: Color = Color.White,
    image: Int,
    data: WeatherData
) {
    Card(
        backgroundColor = CardWhite,
        shape = RoundedCornerShape(MaterialTheme.dimensions.medium),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = getImage(data.cityName)),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .alpha(0.1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            contentDescription = ""
        )
        Column(
            modifier = modifier
                .padding(MaterialTheme.dimensions.large)
        ) {
            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .height(MaterialTheme.dimensions.xxxLarge)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.dimensions.xxxLarge),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.cityName,
                    color = textColor,
                    style = MaterialTheme.type.bodyLarge
                )
                Text(
                    text = "${data.temperatureCelsius.roundToInt()}°C",
                    color = textColor,
                    style = MaterialTheme.type.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
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

fun getImage(cityName: String): Int {
    when (cityName) {
        "New York, US" -> return R.drawable.nyc
        "Singapore, SG" -> return R.drawable.singapore
        "Mumbai, IN" -> return R.drawable.mumbai
        "Delhi, IN" -> return R.drawable.delhi
        "Sydney, AU" -> return R.drawable.sydney
        "Melbourne, AU" -> return R.drawable.melbourne
    }
    return R.drawable.ic_01d
}
