package com.ardidong.weatherornot.app.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ardidong.weatherornot.app.R

@Composable
fun HomeScreen(){
    MaterialTheme() {
       Scaffold(
           topBar = { TopAppBar(title = { Text(text = "Top Bar")}) }
       ) { paddingValues ->  
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                Text(text = "body")
            }
       }
    }
}

@Preview
@Composable
fun WeatherSummary(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SummaryTimeDate()
            SummaryTempAndWeather()
        }
    }
}

@Composable
fun SummaryTempAndWeather(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row{
                Text(text = "27", fontSize = 64.sp)
                Text(text = "C", fontSize = 24.sp)
            }
            Text(fontWeight = FontWeight.Light,text = "Feels like 23")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(72.dp),
                painter = painterResource(id = R.drawable.ic_baseline_cloud_24),
                contentDescription = "weather_icon"
            )
            CurrentWeather()
        }
    }
}

@Composable
fun CurrentWeather(){
    Card(

        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Gray
    ){
        Text(
            modifier = Modifier.padding(4.dp),
            text = "Cloudy"
        )
    }
}

@Composable
fun SummaryTimeDate(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(text = "Sleman")
            Text(
                fontWeight = FontWeight.Light,
                text = "6 Januari 2023"
            )
        }
        Text(text = "10.00")
    }
}