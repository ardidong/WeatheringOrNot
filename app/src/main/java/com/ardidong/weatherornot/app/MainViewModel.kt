package com.ardidong.weatherornot.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private var _result = MutableLiveData<CurrentWeather>()
    val observableResult : LiveData<CurrentWeather> get() = _result

    init {
        viewModelScope.launch {
            dispatchGetCurrentWeather().fold(
                success = { _result.postValue(it) },
                failure = {}
            )
        }
    }
}