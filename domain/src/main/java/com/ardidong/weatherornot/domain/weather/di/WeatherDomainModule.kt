package com.ardidong.weatherornot.domain.weather.di

import com.ardidong.weatherornot.domain.weather.GetCurrentWeatherUseCase
import com.ardidong.weatherornot.domain.weather.GetCurrentWeatherUseCaseImpl
import com.ardidong.weatherornot.domain.weather.onecall.GetWeatherDataUseCase
import com.ardidong.weatherornot.domain.weather.onecall.GetWeatherDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class WeatherDomainModule {

    @Binds
    abstract fun bindGetCurrentWeatherUseCase(
        getCurrentWeatherUseCaseImpl: GetCurrentWeatherUseCaseImpl
    ): GetCurrentWeatherUseCase

    @Binds
    abstract fun bindGetWeatherDataUseCase(
        getWeatherDataUseCaseImpl: GetWeatherDataUseCaseImpl
    ): GetWeatherDataUseCase
}