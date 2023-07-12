package com.ardidong.weatherornot.domain.weather.model

data class Current(
	val sunrise: Int,
	val temp: Double,
	val visibility: Int,
	val uvi: Double,
	val pressure: Int,
	val clouds: Int,
	val feelsLike: Double,
	val windGust: Double,
	val dt: Int,
	val windDeg: Int,
	val dewPoint: Double,
	val sunset: Int,
	val weather: List<WeatherItem>,
	val humidity: Int,
	val windSpeed: Double
)