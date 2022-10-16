package com.ardidong.weatherornot.domain.weather

import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import javax.inject.Inject

class GetCurrentWeatherUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository
) : GetCurrentWeatherUseCase {
    override suspend fun invoke(): ResultOf<CurrentWeather> {
        return repository.getCurrentWeather().fold(
            success = {
                ResultOf.Success(it)
            },
            failure = {
                ResultOf.Failure(it)
            }
        )
    }
}