package com.ardidong.weatherornot.domain.weather.di

import com.ardidong.weatherornot.domain.weather.GetCurrentWeatherUseCase
import com.ardidong.weatherornot.domain.weather.GetCurrentWeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class WeatherDomainModule {

    @Binds
    abstract fun bindGetCurrentWeatherUseCase(
        getCurrentWeatherUseCaseImpl: GetCurrentWeatherUseCaseImpl
    ): GetCurrentWeatherUseCase
}