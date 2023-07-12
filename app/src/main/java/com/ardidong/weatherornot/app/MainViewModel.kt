package com.ardidong.weatherornot.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardidong.weatherornot.domain.common.ErrorEntity
import com.ardidong.weatherornot.domain.weather.GetCurrentWeatherUseCase
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import com.ardidong.weatherornot.domain.weather.model.WeatherData
import com.ardidong.weatherornot.domain.weather.onecall.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchGetCurrentWeather: GetCurrentWeatherUseCase,
    private val dispatchGetWeatherData: GetWeatherDataUseCase
) : ViewModel() {

    private var _result = MutableLiveData<CurrentWeatherState>()
    val observableResult : LiveData<CurrentWeatherState> get() = _result

    private var _weatherData = MutableLiveData<WeatherDataState>()
    val observableWeatherData: LiveData<WeatherDataState> get() = _weatherData

    init {
        getCurrentWeather()
    }

    fun getCurrentWeather(){
        _result.value = CurrentWeatherState.IsLoading
        viewModelScope.launch {
            dispatchGetCurrentWeather().fold(
                success = {
                    _result.postValue(
                        CurrentWeatherState.DataFetched(
                            currentWeather = it
                        )
                    )
                },
                failure = {
                    _result.postValue(CurrentWeatherState.Error(it))
                }
            )
        }
    }

    fun getWeatherData(){
        _weatherData.value = WeatherDataState.IsLoading
        viewModelScope.launch {
            dispatchGetWeatherData().fold(
                success = {
                    _weatherData.postValue(
                        WeatherDataState.DataFetched(it)
                    )
                },
                failure = {
                    _weatherData.postValue(WeatherDataState.Error(it))
                }
            )
        }
    }
}

sealed class CurrentWeatherState{
    object IsLoading : CurrentWeatherState()

    data class DataFetched(
        val currentWeather: CurrentWeather
    ) : CurrentWeatherState()

    data class Error(
        val errorEntity: ErrorEntity
    ) : CurrentWeatherState()
}

sealed class WeatherDataState{
    object IsLoading : WeatherDataState()

    data class DataFetched(
        val data: WeatherData
    ) : WeatherDataState()

    data class Error(
        val errorEntity: ErrorEntity
    ) : WeatherDataState()
}