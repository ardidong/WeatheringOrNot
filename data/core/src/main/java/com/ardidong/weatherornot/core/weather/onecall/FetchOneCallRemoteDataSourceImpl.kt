package com.ardidong.weatherornot.core.weather.onecall

import com.ardidong.weatherornot.core.weather.mapper.WeatherDataMapper
import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.WeatherData
import com.ardidong.weatherornot.library.network.NetworkClient
import javax.inject.Inject

class FetchOneCallRemoteDataSourceImpl @Inject constructor(
    private val networkClient: NetworkClient
) : FetchOneCallRemoteDataSource {

    private val mapper = WeatherDataMapper()

    override suspend fun invoke(
        lat: Double,
        lon: Double,
        appId: String,
        units: String
    ): ResultOf<WeatherData> {
        val client = networkClient.getInstance(OneCallWeatherApiService::class.java)
        return networkClient.handleApi{client.oneCallWeather(lat, lon, appId, units, "minutely")}.fold(
            success = {
                ResultOf.Success(mapper.toModel(it))
            },
            failure = {
                ResultOf.Failure(it)
            }
        )
    }
}
