package com.ardidong.weatherornot.core.weather.onecall

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.WeatherData

interface FetchOneCallRemoteDataSource {
    suspend operator fun invoke(
        lat: Double,
        lon: Double,
        appId: String,
        units: String
    ) : ResultOf<WeatherData>
}