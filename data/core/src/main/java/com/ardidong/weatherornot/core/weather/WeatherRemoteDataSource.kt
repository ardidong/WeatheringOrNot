package com.ardidong.weatherornot.core.weather

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import dagger.Component

@Component
interface WeatherRemoteDataSource {
    suspend fun getCurrentWeather(): ResultOf<CurrentWeather>
}