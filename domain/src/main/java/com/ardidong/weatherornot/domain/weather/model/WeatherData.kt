package com.ardidong.weatherornot.domain.weather.model

data class WeatherData(
	val current: Current,
	val timezone: String,
	val timezoneOffset: Int,
	val daily: List<DailyItem>,
	val lon: Double,
	val hourly: List<HourlyItem>,
	val lat: Double
)
