package com.ardidong.weatherornot.domain.weather.onecall

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.WeatherRepository
import com.ardidong.weatherornot.domain.weather.model.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWeatherDataUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository
): GetWeatherDataUseCase {
    override suspend fun invoke(): ResultOf<WeatherData> = withContext(Dispatchers.IO){
        return@withContext repository.oneCallWeather(
            lat = -7.7211222,
            lon = 110.3478211,
            units = "metric"
        )
    }
}