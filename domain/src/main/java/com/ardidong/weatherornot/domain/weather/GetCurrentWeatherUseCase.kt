package com.ardidong.weatherornot.domain.weather

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather

interface GetCurrentWeatherUseCase {
    suspend operator fun invoke(): ResultOf<String>
}