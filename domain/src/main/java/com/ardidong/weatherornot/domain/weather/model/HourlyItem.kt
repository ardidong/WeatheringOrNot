package com.ardidong.weatherornot.domain.weather.model

data class HourlyItem(
	val temp: Double,
	val visibility: Int,
	val uvi: Double,
	val pressure: Int,
	val clouds: Int,
	val feelsLike: Double,
	val windGust: Double,
	val dt: Int,
	val pop: Int,
	val windDeg: Int,
	val dewPoint: Double,
	val weather: List<WeatherItem>,
	val humidity: Int,
	val windSpeed: Double
)
