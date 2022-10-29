package com.ardidong.weatherornot.core.weather

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.WeatherRepository
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {

    override suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
        units: String
    ): ResultOf<CurrentWeather> {
        val apiKey = "282f7c488fd855c229e2d7eee4b75dd4"

        return remoteDataSource.getCurrentWeather(
            lat = lat,
            lon = lon,
            appId = apiKey,
            units = units
        )
    }
}