package com.ardidong.weatherornot.core.weather.onecall

import com.ardidong.weatherornot.core.weather.model.OneCallWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OneCallWeatherApiService {
    @GET("data/2.5/onecall")
    suspend fun oneCallWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String,
        @Query("units") units: String,
        @Query("exclude") exclude: String,
    ): Response<OneCallWeatherResponse>
}