package com.ardidong.weatherornot.app.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.ardidong.weatherornot.app.MainViewModel
import com.ardidong.weatherornot.app.R
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import kotlin.math.roundToInt

@Composable
fun HomeScreen(){
    val viewModel = hiltViewModel<MainViewModel>()
    val currentWeather = viewModel.observableResult.observeAsState(initial = null)

    MaterialTheme() {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "Top Bar")}) }
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {

                if(currentWeather.value !=  null){
                    WeatherSummary(currentWeather.value!!)
                }
            }
        }
    }
}

@Preview
@Composable
fun WeatherSummary(currentWeather: CurrentWeather = CurrentWeather.DUMMY){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Sleman", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            SummaryTempAndWeather( modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
                currentWeather = currentWeather
            )
            SummaryOtherInfo(currentWeather)
        }
    }
}

@Composable
fun SummaryTempAndWeather(currentWeather: CurrentWeather ,modifier: Modifier){
    Row(
        modifier = modifier,
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
                modifier = Modifier.size(72.dp),
                painter = painterResource(id = R.drawable.ic_baseline_cloud_24),
                contentDescription = "weather_icon"
            )
            CurrentWeatherIcon(currentWeather.weather[0].main)
        }
    }
}

@Composable
fun CurrentWeatherIcon(weatherInfo: String){
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Gray
    ){
        Text(
            modifier = Modifier.padding(4.dp),
            text = weatherInfo
        )
    }
}

@Composable
fun SummaryOtherInfo(currentWeather: CurrentWeather){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val rowAlignment = Alignment.CenterVertically
        val iconModifier = Modifier
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