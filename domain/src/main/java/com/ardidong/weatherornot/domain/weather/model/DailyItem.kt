package com.ardidong.weatherornot.domain.weather.model

data class DailyItem(
	val moonset: Int,
	val sunrise: Int,
	val temp: Temp,
	val moonPhase: Double,
	val uvi: Double,
	val moonrise: Int,
	val pressure: Int,
	val clouds: Int,
	val feelsLike: FeelsLike,
	val windGust: Double,
	val dt: Int,
	val pop: Double,
	val windDeg: Int,
	val dewPoint: Double,
	val sunset: Int,
	val weather: List<WeatherItem>,
	val humidity: Int,
	val windSpeed: Double
){
	data class FeelsLike(
		val eve: Double,
		val night: Double,
		val day: Double,
		val morn: Double
	)

	data class Temp(
		val min: Double,
		val max: Double,
		val eve: Double,
		val night: Double,
		val day: Double,
		val morn: Double
	)
}
