package com.ardidong.weatherornot.core.weather

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.WeatherRepository
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather

class WeatherRepositoryImpl(
//    private val remoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {

//    override suspend fun getCurrentWeather(): ResultOf<CurrentWeather> {
//        return remoteDataSource.getCurrentWeather()
//    }

    override suspend fun getCurrentWeather(): ResultOf<String> {
        return ResultOf.Success("FFFF")
    }
}