package com.ardidong.weatherornot.core.weather

import com.ardidong.weatherornot.core.BuildConfig
import com.ardidong.weatherornot.core.weather.onecall.FetchOneCallRemoteDataSource
import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.WeatherRepository
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import com.ardidong.weatherornot.domain.weather.model.WeatherData
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource,
    private val oneCallWeather : FetchOneCallRemoteDataSource
) : WeatherRepository {

    override suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
        units: String
    ): ResultOf<CurrentWeather> {
        return remoteDataSource.getCurrentWeather(
            lat = lat,
            lon = lon,
            appId = BuildConfig.openWeatherKey,
            units = units
        )
    }

    override suspend fun oneCallWeather(
        lat: Double,
        lon: Double,
        units: String
    ): ResultOf<WeatherData> {
        return oneCallWeather(
            lat = lat,
            lon = lon,
            appId = BuildConfig.openWeatherKey,
            units = units
        )
    }
}