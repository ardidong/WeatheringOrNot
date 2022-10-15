package com.ardidong.weatherornot.core.weather.di

import com.ardidong.weatherornot.core.weather.WeatherRepositoryImpl
import com.ardidong.weatherornot.domain.weather.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class WeatherDataModule {

    @Binds
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}