package com.assignment.weatherapp.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.assignment.weatherapp.R


private val Gilmer = FontFamily(
    Font(R.font.gilmer_light, FontWeight.W300),
    Font(R.font.gilmer_regular, FontWeight.W400),
    Font(R.font.gilmer_medium, FontWeight.W500),
    Font(R.font.gilmer_bold, FontWeight.W600)
)

data class Typo(
    val displayLarge: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W500,
        fontSize = 50.sp,
        lineHeight = 58.sp,
        color = Color.White
    ),
    val displayMedium: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        color = Color.White
    ),
    val displaySmall: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        color = Color.White
    ),
    val headlineLarge: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp,
        lineHeight = 35.sp,
        color = Color.White
    ),
    val headlineMedium: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
        lineHeight = 29.sp,
        color = Color.White
    ),
    val headlineSmall: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 25.sp,
        color = Color.White
    ),
    val bodyExtraLarge: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        lineHeight = 32.sp,
        color = Color.White
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        color = Color.White
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        color = Color.White
    ),
    val bodySmall: TextStyle = TextStyle(
        fontFamily = Gilmer,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        color = Color.White
    )
)

val LocalTypography = compositionLocalOf { Typo() }

val MaterialTheme.type: Typo
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current