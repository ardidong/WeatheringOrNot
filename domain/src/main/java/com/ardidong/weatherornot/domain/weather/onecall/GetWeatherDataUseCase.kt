package com.ardidong.weatherornot.domain.weather.onecall

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.WeatherData

interface GetWeatherDataUseCase {
    suspend operator fun invoke() : ResultOf<WeatherData>
}