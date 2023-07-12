package com.ardidong.weatherornot.app.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ardidong.weatherornot.app.CurrentWeatherState
import com.ardidong.weatherornot.app.MainViewModel
import com.ardidong.weatherornot.app.R
import com.ardidong.weatherornot.app.WeatherDataState
import com.ardidong.weatherornot.app.presentation.theme.WeatherOrNotTheme
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import kotlin.math.roundToInt

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
){
    val currentWeatherObs = viewModel.observableResult.observeAsState(CurrentWeatherState.IsLoading)
    val weatherDataObs = viewModel.observableWeatherData.observeAsState(WeatherDataState.IsLoading)

    WeatherOrNotTheme {
        val scaffoldState = rememberScaffoldState()

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(elevation = 10.dp ,title = { Text(text = "Top Bar")})
            },
        ) { paddingValues ->
            Column(
                modifier = modifier.padding(paddingValues)
            ) {

                Column() {
                    Button(
                        onClick = {
                            viewModel.getCurrentWeather()
                            viewModel.getWeatherData()
                        }
                    ) {
                        Text(text = "Get Data")
                    }
                    when(val currentWeather = currentWeatherObs.value){
                        is CurrentWeatherState.DataFetched -> {
                            WeatherSummary(
                                currentWeather = currentWeather.currentWeather
                            )
                        }
                        is CurrentWeatherState.Error -> {
                            LaunchedEffect(key1 = scaffoldState.snackbarHostState ){
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = currentWeather.errorEntity.message,
                                    actionLabel = "Action",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }

                        else -> {}
                    }

                    when(val state = weatherDataObs.value){
                        is WeatherDataState.DataFetched -> {
                            Text(text = state.toString())
                        }

                        is WeatherDataState.Error -> {
                            LaunchedEffect(key1 = scaffoldState.snackbarHostState ){
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = state.errorEntity.message,
                                    actionLabel = "Action",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }

                        else -> {}
                    }
                }

            }
        }
    }
}
@Composable
fun WeatherSummary(modifier: Modifier = Modifier, currentWeather: CurrentWeather){
    Surface(
        elevation = 16.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Sleman", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            SummaryTempAndWeather(
                currentWeather = currentWeather
            )
            SummaryOtherInfo(currentWeather)
        }
    }
}

@Composable
fun SummaryTempAndWeather(modifier: Modifier = Modifier, currentWeather: CurrentWeather){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row{
                Text(text = currentWeather.main.temp.roundToInt().toString(), fontSize = 64.sp)
                Text(text = "C", fontSize = 24.sp)
            }
            Text(fontWeight = FontWeight.Light,text = "Feels like ${currentWeather.main.feelsLike.roundToInt()}")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = modifier.size(72.dp),
                painter = painterResource(id = R.drawable.ic_baseline_cloud_24),
                contentDescription = "weather_icon"
            )
            CurrentWeatherIcon(currentWeather.weather[0].main)
        }
    }
}

@Composable
fun CurrentWeatherIcon(weatherInfo: String, modifier: Modifier = Modifier){
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Gray
    ){
        Text(
            modifier = modifier.padding(4.dp),
            text = weatherInfo
        )
    }
}

@Composable
fun SummaryOtherInfo(
    currentWeather: CurrentWeather,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        val rowAlignment = Alignment.CenterVertically
        val iconModifier = modifier
            .size(28.dp)
            .padding(2.dp)

        Row(
            verticalAlignment = rowAlignment
        ) {
            Icon(
                modifier = iconModifier,
                painter = painterResource(id = R.drawable.ic_baseline_wind_power_24),
                contentDescription = "wind_speed"
            )
            Text(text = "${currentWeather.wind.speed.roundToInt()} km/h")
        }

        Row(
            verticalAlignment = rowAlignment
        ) {
            Icon(
                modifier = iconModifier,
                painter = painterResource(id = R.drawable.ic_outline_water_drop_24),
                contentDescription = "humidity"
            )
            Text(text = "${currentWeather.main.humidity}%")
        }

        Row(
            verticalAlignment = rowAlignment
        ){
            Icon(
                modifier = iconModifier,
                painter = painterResource(id = R.drawable.ic_outline_cloud_24),
                contentDescription = "cloud_coverage"
            )
            Text(text = "${currentWeather.clouds.all}%")
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    WeatherOrNotTheme(){
        WeatherSummary(currentWeather = CurrentWeather.DUMMY)
    }
}