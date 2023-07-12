package com.ardidong.weatherornot.core.weather.di

import com.ardidong.weatherornot.core.weather.WeatherRemoteDataSource
import com.ardidong.weatherornot.core.weather.WeatherRemoteDataSourceImpl
import com.ardidong.weatherornot.core.weather.WeatherRepositoryImpl
import com.ardidong.weatherornot.core.weather.onecall.FetchOneCallRemoteDataSource
import com.ardidong.weatherornot.core.weather.onecall.FetchOneCallRemoteDataSourceImpl
import com.ardidong.weatherornot.domain.weather.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class WeatherDataModule {

    @Binds
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    abstract fun bindWeatherRemoteDataSource(
        weatherRemoteDataSourceImpl: WeatherRemoteDataSourceImpl
    ): WeatherRemoteDataSource


    @Binds
    abstract fun bindFetchOneCallRemoteDataSource(
        fetchOneCallRemoteDataSourceImpl: FetchOneCallRemoteDataSourceImpl
    ): FetchOneCallRemoteDataSource
}