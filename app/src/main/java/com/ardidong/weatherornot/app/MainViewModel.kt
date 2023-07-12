package com.ardidong.weatherornot.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardidong.weatherornot.domain.common.ErrorEntity
import com.ardidong.weatherornot.domain.weather.GetCurrentWeatherUseCase
import com.ardidong.weatherornot.domain.weather.model.CurrentWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchGetCurrentWeather: GetCurrentWeatherUseCase
) : ViewModel() {

    private var _result = MutableLiveData<CurrentWeatherState>()
    val observableResult : LiveData<CurrentWeatherState> get() = _result

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