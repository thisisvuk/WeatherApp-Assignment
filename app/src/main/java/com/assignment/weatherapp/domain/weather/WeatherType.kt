package com.assignment.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.assignment.weatherapp.R

sealed class WeatherType(
    val weatherDesc: String, @DrawableRes var iconRes: Int
) {

    object LightRainThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with light rain", iconRes = R.drawable.ic_11d
    )

    object RainThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with rain", iconRes = R.drawable.ic_11d
    )

    object HeavyRainThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with heavy rain", iconRes = R.drawable.ic_11d
    )

    object LightThunderstorm : WeatherType(
        weatherDesc = "Light thunderstorm", iconRes = R.drawable.ic_11d
    )

    object Thunderstorm : WeatherType(
        weatherDesc = "Thunderstorm", iconRes = R.drawable.ic_11d
    )

    object HeavyThunderstorm : WeatherType(
        weatherDesc = "Heavy thunderstorm", iconRes = R.drawable.ic_11d
    )

    object RaggedThunderstorm : WeatherType(
        weatherDesc = "Ragged thunderstorm", iconRes = R.drawable.ic_11d
    )

    object LightDrizzleThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with light drizzle", iconRes = R.drawable.ic_11d
    )

    object DrizzleThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with drizzle", iconRes = R.drawable.ic_11d
    )

    object HeavyDrizzleThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with heavy drizzle", iconRes = R.drawable.ic_11d
    )

    object LightIntensityDrizzle : WeatherType(
        weatherDesc = "Light intensity drizzle", iconRes = R.drawable.ic_09d
    )

    object Drizzle : WeatherType(
        weatherDesc = "Drizzle", iconRes = R.drawable.ic_09d
    )

    object HeavyIntensityDrizzle : WeatherType(
        weatherDesc = "Heavy intensity drizzle", iconRes = R.drawable.ic_09d
    )

    object LightIntensityDrizzleRain : WeatherType(
        weatherDesc = "Light intensity drizzle rain", iconRes = R.drawable.ic_09d
    )

    object DrizzleRain : WeatherType(
        weatherDesc = "Drizzle rain", iconRes = R.drawable.ic_09d
    )

    object HeavyIntensityDrizzleRain : WeatherType(
        weatherDesc = "Heavy intensity drizzle rain", iconRes = R.drawable.ic_09d
    )

    object ShowerRainAndDrizzle : WeatherType(
        weatherDesc = "Shower rain and drizzle", iconRes = R.drawable.ic_09d
    )

    object HeavyShowerRainAndDrizzle : WeatherType(
        weatherDesc = "Heavy shower rain and drizzle", iconRes = R.drawable.ic_09d
    )

    object ShowerDrizzle : WeatherType(
        weatherDesc = "Shower drizzle", iconRes = R.drawable.ic_09d
    )

    object LightRain : WeatherType(
        weatherDesc = "Light rain", iconRes = R.drawable.ic_10d
    )

    object ModerateRain : WeatherType(
        weatherDesc = "Moderate rain", iconRes = R.drawable.ic_10d
    )

    object HeavyIntensityRain : WeatherType(
        weatherDesc = "Heavy intensity rain", iconRes = R.drawable.ic_10d
    )

    object VeryHeavyRain : WeatherType(
        weatherDesc = "Very heavy rain", iconRes = R.drawable.ic_10d
    )

    object ExtremeRain : WeatherType(
        weatherDesc = "Extreme rain", iconRes = R.drawable.ic_10d
    )

    object LightRainN : WeatherType(
        weatherDesc = "Light rain", iconRes = R.drawable.ic_10n
    )

    object ModerateRainN : WeatherType(
        weatherDesc = "Moderate rain", iconRes = R.drawable.ic_10n
    )

    object HeavyIntensityRainN : WeatherType(
        weatherDesc = "Heavy intensity rain", iconRes = R.drawable.ic_10n
    )

    object VeryHeavyRainN : WeatherType(
        weatherDesc = "Very heavy rain", iconRes = R.drawable.ic_10n
    )

    object ExtremeRainN : WeatherType(
        weatherDesc = "Extreme rain", iconRes = R.drawable.ic_10n
    )

    object FreezingRain : WeatherType(
        weatherDesc = "Freezing rain", iconRes = R.drawable.ic_13d
    )

    object LightIntensityShowerRain : WeatherType(
        weatherDesc = "Light intensity shower rain", iconRes = R.drawable.ic_09d
    )

    object ShowerRain : WeatherType(
        weatherDesc = "Shower rain", iconRes = R.drawable.ic_09d
    )

    object HeavyIntensityShowerRain : WeatherType(
        weatherDesc = "Heavy intensity shower rain", iconRes = R.drawable.ic_09d
    )

    object RaggedShowerRain : WeatherType(
        weatherDesc = "Ragged shower rain", iconRes = R.drawable.ic_09d
    )

    object LightSnow : WeatherType(
        weatherDesc = "Light snow", iconRes = R.drawable.ic_13d
    )

    object Snow : WeatherType(
        weatherDesc = "Snow", iconRes = R.drawable.ic_13d
    )

    object HeavySnow : WeatherType(
        weatherDesc = "Heavy snow", iconRes = R.drawable.ic_13d
    )

    object Sleet : WeatherType(
        weatherDesc = "Sleet", iconRes = R.drawable.ic_13d
    )

    object LightShowerSleet : WeatherType(
        weatherDesc = "Light shower sleet", iconRes = R.drawable.ic_13d
    )

    object ShowerSleet : WeatherType(
        weatherDesc = "Shower sleet", iconRes = R.drawable.ic_13d
    )

    object LightRainAndSnow : WeatherType(
        weatherDesc = "Light rain and snow", iconRes = R.drawable.ic_13d
    )

    object RainAndSnow : WeatherType(
        weatherDesc = "Rain and snow", iconRes = R.drawable.ic_13d
    )

    object LightShowerSnow : WeatherType(
        weatherDesc = "Light shower snow", iconRes = R.drawable.ic_13d
    )

    object ShowerSnow : WeatherType(
        weatherDesc = "Shower", iconRes = R.drawable.ic_13d
    )

    object HeavyShowerSnow : WeatherType(
        weatherDesc = "Heavy shower snow", iconRes = R.drawable.ic_13d
    )

    object Mist : WeatherType(
        weatherDesc = "Mist", iconRes = R.drawable.ic_50d
    )

    object Smoke : WeatherType(
        weatherDesc = "Smoke", iconRes = R.drawable.ic_50d
    )

    object Haze : WeatherType(
        weatherDesc = "Haze", iconRes = R.drawable.ic_50d
    )

    object SandWhirls : WeatherType(
        weatherDesc = "Sand/Dust whirls", iconRes = R.drawable.ic_50d
    )

    object Fog : WeatherType(
        weatherDesc = "Fog", iconRes = R.drawable.ic_50d
    )

    object Sand : WeatherType(
        weatherDesc = "Sand", iconRes = R.drawable.ic_50d
    )

    object Dust : WeatherType(
        weatherDesc = "Dust", iconRes = R.drawable.ic_50d
    )

    object VolcanicAsh : WeatherType(
        weatherDesc = "Volcanic ash", iconRes = R.drawable.ic_50d
    )

    object Squalls : WeatherType(
        weatherDesc = "Squalls", iconRes = R.drawable.ic_50d
    )

    object Tornado : WeatherType(
        weatherDesc = "Tornado", iconRes = R.drawable.ic_50d
    )

    object ClearSky : WeatherType(
        weatherDesc = "Clear Sky", iconRes = R.drawable.ic_01d
    )

    object ClearSkyN : WeatherType(
        weatherDesc = "Clear Sky", iconRes = R.drawable.ic_01n
    )

    object Clouds1125 : WeatherType(
        weatherDesc = "Few clouds: 11-25%", iconRes = R.drawable.ic_02d
    )

    object Clouds1125N : WeatherType(
        weatherDesc = "Few clouds: 11-25%", iconRes = R.drawable.ic_02n
    )

    object Clouds2550 : WeatherType(
        weatherDesc = "Scattered clouds: 25-50%", iconRes = R.drawable.ic_03d
    )

    object Clouds5184 : WeatherType(
        weatherDesc = "Broken clouds: 51-84%", iconRes = R.drawable.ic_04d
    )

    object Clouds85100 : WeatherType(
        weatherDesc = "Overcast clouds: 85-100%", iconRes = R.drawable.ic_04d
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                200 -> LightRainThunderstorm
                201 -> RainThunderstorm
                202 -> HeavyRainThunderstorm
                210 -> LightThunderstorm
                211 -> Thunderstorm
                212 -> HeavyThunderstorm
                221 -> RaggedThunderstorm
                230 -> LightDrizzleThunderstorm
                231 -> DrizzleThunderstorm
                232 -> HeavyDrizzleThunderstorm

                300 -> LightIntensityDrizzle
                301 -> Drizzle
                302 -> HeavyIntensityDrizzle
                310 -> LightIntensityDrizzleRain
                311 -> DrizzleRain
                312 -> HeavyIntensityDrizzleRain
                313 -> ShowerRainAndDrizzle
                314 -> HeavyShowerRainAndDrizzle
                321 -> ShowerDrizzle

                500 -> LightRain
                501 -> ModerateRain
                502 -> HeavyIntensityRain
                503 -> VeryHeavyRain
                504 -> ExtremeRain
                511 -> FreezingRain
                520 -> LightIntensityShowerRain
                521 -> ShowerRain
                522 -> HeavyIntensityShowerRain
                531 -> RaggedShowerRain

                600 -> LightSnow
                601 -> Snow
                602 -> HeavySnow
                611 -> Sleet
                612 -> LightShowerSleet
                613 -> ShowerSleet
                615 -> LightRainAndSnow
                616 -> RainAndSnow
                620 -> LightShowerSnow
                621 -> ShowerSnow
                622 -> HeavyShowerSnow

                701 -> Mist
                711 -> Smoke
                721 -> Haze
                731 -> SandWhirls
                741 -> Fog
                751 -> Sand
                761 -> Dust
                762 -> VolcanicAsh
                771 -> Squalls
                781 -> Tornado

                800 -> ClearSky
                801 -> Clouds1125
                802 -> Clouds2550
                803 -> Clouds5184
                804 -> Clouds85100

                1800 -> ClearSkyN
                1801 -> Clouds1125N
                1500 -> LightRainN
                1501 -> ModerateRainN
                1502 -> HeavyIntensityRainN
                1503 -> VeryHeavyRainN
                1504 -> ExtremeRainN

                else -> ClearSky
            }
        }
    }
}