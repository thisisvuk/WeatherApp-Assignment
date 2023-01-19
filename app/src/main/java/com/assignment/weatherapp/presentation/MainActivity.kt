package com.assignment.weatherapp.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.lifecycleScope
import com.assignment.weatherapp.R
import com.assignment.weatherapp.data.network.isInternetAvailable
import com.assignment.weatherapp.presentation.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (isInternetAvailable(applicationContext)) {
                viewModel.loadWeatherInfo(applicationContext, lifecycleScope)
            } else {
                viewModel.loadWeatherInfoLocal(applicationContext, lifecycleScope)
            }
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )

        setContent {
            WeatherAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Background)
                            .verticalScroll(rememberScrollState())
                    ) {
                        WeatherCard(
                            state = viewModel.state,
                            backgroundColor = CardWhite
                        )
                        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
                        WeatherForecast(state = viewModel.state)
                        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
                        CityView(state = viewModel.state)
                        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
                        Text(
                            text = getString(R.string.last_update_on) + viewModel.state.weatherInfo?.currentWeatherData?.time?.format(
                                DateTimeFormatter.ofPattern("MM/dd/yyyy E hh:mm:ss a")
                            ).toString(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.type.bodySmall,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))

                    }
                    if (viewModel.state.isLoading) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    viewModel.state.error?.let { error ->
                        Text(
                            text = error,
                            color = Color.Red,
                            style = MaterialTheme.type.bodyLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}