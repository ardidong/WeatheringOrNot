package com.ardidong.weatherornot.core.weather.mapper

import com.ardidong.weatherornot.core.weather.model.CurrentWeatherResponse
import com.ardidong.weatherornot.domain.common.extension.orMinValue
import com.ardidong.weatherornot.domain.common.extension.orMinus
import com.ardidong.weatherornot.domain.common.mapper.ResponseToModel
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather

class CurrentWeatherMapper : ResponseToModel<CurrentWeatherResponse, CurrentWeather> {
    override fun toModel(response: CurrentWeatherResponse): CurrentWeather {
        return CurrentWeather(
            visibility = response.visibility.orMinus(),
            timezone = response.timezone.orMinus(),
            main = CurrentWeather.Main(
                temp = response.main?.temp.orMinValue(),
                tempMin = response.main?.tempMin.orMinValue(),
                grndLevel = response.main?.grndLevel.orMinValue(),
                humidity = response.main?.humidity.orMinValue(),
                pressure = response.main?.pressure.orMinValue(),
                seaLevel = response.main?.seaLevel.orMinValue(),
                feelsLike = response.main?.feelsLike.orMinValue(),
                tempMax = response.main?.tempMax.orMinValue(),
            ),
            clouds = CurrentWeather.Clouds(
                all = response.clouds?.all.orMinValue()
            ),
            sys = CurrentWeather.Sys(
                country = response.sys?.country.orEmpty(),
                sunrise = response.sys?.sunrise.orMinValue(),
                sunset = response.sys?.sunset.orMinValue()
            ),
            dt = response.dt.orMinValue(),
            coord = CurrentWeather.Coord(
                lon = response.coord?.lon.orMinValue(),
                lat = response.coord?.lat.orMinValue()
            ),
            weather = response.weather?.map { item ->
                CurrentWeather.WeatherItem(
                    icon = item?.icon.orEmpty(),
                    description = item?.icon.orEmpty(),
                    main = item?.main.orEmpty(),
                    id = item?.id.orMinus()
                )
            } ?: emptyList(),
            name = response.name.orEmpty(),
            cod = response.cod.orMinus(),
            id = response.id.orMinus(),
            base = response.base.orEmpty(),
            wind = CurrentWeather.Wind(
                deg = response.wind?.deg.orMinValue(),
                speed = response.wind?.speed.orMinValue(),
                gust = response.wind?.gust.orMinValue()
            ),
        )
    }
}