package com.ardidong.weatherornot.core.weather.mapper

import com.ardidong.weatherornot.core.weather.model.OneCallWeatherResponse
import com.ardidong.weatherornot.domain.common.extension.orMinValue
import com.ardidong.weatherornot.domain.common.extension.orMinus
import com.ardidong.weatherornot.domain.common.mapper.ResponseToModel
import com.ardidong.weatherornot.domain.weather.model.*

class WeatherDataMapper : ResponseToModel<OneCallWeatherResponse, WeatherData> {
    override fun toModel(response: OneCallWeatherResponse): WeatherData {
        return WeatherData(
            timezone = response.timezone.orEmpty(),
            timezoneOffset = response.timezoneOffset.orMinus(),
            lon = response.lon.orMinValue(),
            lat = response.lat.orMinValue(),
            daily = mapDaily(response),
            hourly = mapHourly(response),
            current = mapCurrent(response)
        )
    }

    private fun mapCurrent(response: OneCallWeatherResponse) = Current(
        sunrise = response.current?.sunrise.orMinus(),
        temp = response.current?.temp.orMinValue(),
        visibility = response.current?.visibility.orMinus(),
        uvi = response.current?.uvi.orMinValue(),
        pressure = response.current?.pressure.orMinus(),
        clouds = response.current?.clouds.orMinus(),
        feelsLike = response.current?.feelsLike.orMinValue(),
        windGust = response.current?.windGust.orMinValue(),
        dt = response.current?.dt.orMinValue(),
        windDeg = response.current?.windDeg.orMinus(),
        dewPoint = response.current?.dewPoint.orMinValue(),
        sunset = response.current?.sunset.orMinus(),
        humidity = response.current?.humidity.orMinValue(),
        windSpeed = response.current?.windSpeed.orMinValue(),
        weather = mapWeatherMap(response.current?.weather)
    )

    private fun mapDaily(response: OneCallWeatherResponse) = response.daily?.map { item ->
        DailyItem(
            moonset = item?.moonset.orMinus(),
            sunrise = item?.sunrise.orMinus(),
            moonPhase = item?.moonPhase.orMinus(),
            uvi = item?.uvi.orMinus(),
            moonrise = item?.moonrise.orMinus(),
            pressure = item?.pressure.orMinus(),
            clouds = item?.clouds.orMinus(),
            windGust = item?.windGust.orMinus(),
            dt = item?.dt.orMinus(),
            pop = item?.pop.orMinus(),
            windDeg = item?.windDeg.orMinus(),
            dewPoint = item?.dewPoint.orMinus(),
            sunset = item?.sunset.orMinus(),
            humidity = item?.humidity.orMinus(),
            windSpeed = item?.windSpeed.orMinus(),
            feelsLike = DailyItem.FeelsLike(
                eve = item?.feelsLike?.eve.orMinValue(),
                night = item?.feelsLike?.night.orMinValue(),
                day = item?.feelsLike?.day.orMinValue(),
                morn = item?.feelsLike?.morn.orMinValue()
            ),
            temp = DailyItem.Temp(
                min = item?.temp?.min.orMinValue(),
                max = item?.temp?.max.orMinValue(),
                eve = item?.temp?.eve.orMinValue(),
                night = item?.temp?.night.orMinValue(),
                day = item?.temp?.day.orMinValue(),
                morn = item?.temp?.morn.orMinValue()
            ),
            weather = mapWeatherMap(item?.weather)
        )
    } ?: emptyList()

    private fun mapHourly(response: OneCallWeatherResponse) = response.hourly?.map { item ->
        HourlyItem(
            dt = item?.dt.orMinus(),
            visibility = item?.visibility.orMinus(),
            uvi = item?.uvi.orMinValue(),
            pressure = item?.pressure.orMinValue(),
            clouds = item?.clouds.orMinus(),
            feelsLike = item?.feelsLike.orMinValue(),
            windGust = item?.windGust.orMinus(),
            pop = item?.pop.orMinus(),
            windDeg = item?.windDeg.orMinValue(),
            dewPoint = item?.dewPoint.orMinValue(),
            humidity = item?.humidity.orMinValue(),
            windSpeed = item?.windSpeed.orMinus(),
            weather = mapWeatherMap(item?.weather),
            temp = item?.temp.orMinValue()
        )
    } ?: emptyList()

    private fun mapWeatherMap(
        list: List<OneCallWeatherResponse.WeatherItem?>?
    ): List<WeatherItem> {
        return if (list.isNullOrEmpty()){
            return emptyList()
        } else {
            list.map {
                WeatherItem(
                    icon = it?.icon.orEmpty(),
                    description = it?.description.orEmpty(),
                    main = it?.main.orEmpty(),
                    id = it?.id.orMinus()
                )
            }
        }
    }
}