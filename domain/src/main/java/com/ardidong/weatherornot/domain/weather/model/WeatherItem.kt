package com.ardidong.weatherornot.domain.weather.model

data class WeatherItem(
    val icon: String,
    val description: String,
    val main: String,
    val id: Int
)