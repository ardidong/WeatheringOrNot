package com.ardidong.weatherornot.core.weather

import com.ardidong.weatherornot.core.util.serialize.Deserializer
import com.ardidong.weatherornot.core.weather.mapper.CurrentWeatherMapper
import com.ardidong.weatherornot.core.weather.model.CurrentWeatherResponse
import com.ardidong.weatherornot.domain.common.ResultOf
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(

) : WeatherRemoteDataSource {
    private val deserializer = Deserializer(CurrentWeatherResponse::class.java)
    private val mapper = CurrentWeatherMapper()

    override suspend fun getCurrentWeather(): ResultOf<CurrentWeather> {
        val response = deserializer.deserialize(dummyCurrentWeather)
        return ResultOf.Success(mapper.toModel(response))
    }

    private val dummyCurrentWeather = "{\n" +
            "    \"coord\": {\n" +
            "        \"lon\": 110.3478,\n" +
            "        \"lat\": -7.7211\n" +
            "    },\n" +
            "    \"weather\": [\n" +
            "        {\n" +
            "            \"id\": 804,\n" +
            "            \"main\": \"Clouds\",\n" +
            "            \"description\": \"overcast clouds\",\n" +
            "            \"icon\": \"04d\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"base\": \"stations\",\n" +
            "    \"main\": {\n" +
            "        \"temp\": 27.27,\n" +
            "        \"feels_like\": 30.24,\n" +
            "        \"temp_min\": 27.27,\n" +
            "        \"temp_max\": 27.27,\n" +
            "        \"pressure\": 1009,\n" +
            "        \"humidity\": 79,\n" +
            "        \"sea_level\": 1009,\n" +
            "        \"grnd_level\": 987\n" +
            "    },\n" +
            "    \"visibility\": 10000,\n" +
            "    \"wind\": {\n" +
            "        \"speed\": 3.22,\n" +
            "        \"deg\": 185,\n" +
            "        \"gust\": 3.31\n" +
            "    },\n" +
            "    \"clouds\": {\n" +
            "        \"all\": 88\n" +
            "    },\n" +
            "    \"dt\": 1664604345,\n" +
            "    \"sys\": {\n" +
            "        \"country\": \"ID\",\n" +
            "        \"sunrise\": 1664576601,\n" +
            "        \"sunset\": 1664620402\n" +
            "    },\n" +
            "    \"timezone\": 25200,\n" +
            "    \"id\": 1626754,\n" +
            "    \"name\": \"Sleman\",\n" +
            "    \"cod\": 200\n" +
            "}"
}