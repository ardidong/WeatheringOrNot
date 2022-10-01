package com.ardidong.weatherornot.core

import com.ardidong.weatherornot.core.weather.WeatherRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun getCurrentWeather() {
        runBlocking {
            val repo = WeatherRepositoryImpl().getCurrentWeather().fold(
                success = {
                    it
                },
                failure = {
                    "error"
                }
            )

            println(repo.toString())
            assertNotNull(repo)
        }
    }
}