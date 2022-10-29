package com.ardidong.weatherornot.domain.weather

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
        units: String
    ): ResultOf<CurrentWeather>
}