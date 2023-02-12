package com.ardidong.weatherornot.domain.weather.model

data class CurrentWeather(
	val visibility: Int,
	val timezone: Int,
	val main: Main,
	val clouds: Clouds,
	val sys: Sys,
	val dt: Int,
	val coord: Coord,
	val weather: List<WeatherItem>,
	val name: String,
	val cod: Int,
	val id: Int,
	val base: String,
	val wind: Wind
){
	data class Wind(
		val deg: Int,
		val speed: Double,
		val gust: Double
	)

	data class Clouds(
		val all: Int
	)

	data class Sys(
		val country: String,
		val sunrise: Int,
		val sunset: Int
	)

	data class Main(
		val temp: Double,
		val tempMin: Double,
		val grndLevel: Int,
		val humidity: Int,
		val pressure: Int,
		val seaLevel: Int,
		val feelsLike: Double,
		val tempMax: Double
	)

	data class WeatherItem(
		val icon: String,
		val description: String,
		val main: String,
		val id: Int
	)

	data class Coord(
		val lon: Double,
		val lat: Double
	)

	companion object{
		val DUMMY = CurrentWeather(visibility=5189, timezone=25200, main=Main(temp=27.34, tempMin=27.34, grndLevel=986, humidity=80, pressure=1009, seaLevel=1009, feelsLike=30.51, tempMax=27.34), clouds=Clouds(all=98), sys=Sys(country="ID", sunrise=1676155307, sunset=1676199844), dt=1676184336, coord=Coord(lon=110.3478, lat=-7.7211), weather= listOf( WeatherItem(icon="04d", description="04d", main="Clouds", id=804)), name="Sleman", cod=200, id=1626754, base="stations", wind=Wind(deg=230, speed=3.03, gust=4.0))
	}
}


