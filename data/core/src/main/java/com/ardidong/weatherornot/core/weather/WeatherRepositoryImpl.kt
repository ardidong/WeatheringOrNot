package com.ardidong.weatherornot.core.weather

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.WeatherRepository
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {

    override suspend fun getCurrentWeather(): ResultOf<CurrentWeather> {
        return remoteDataSource.getCurrentWeather()
    }
}