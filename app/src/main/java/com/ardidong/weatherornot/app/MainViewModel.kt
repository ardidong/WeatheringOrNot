package com.ardidong.weatherornot.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardidong.weatherornot.domain.weather.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchGetCurrentWeather: GetCurrentWeatherUseCase
) : ViewModel() {

    private var _result = MutableLiveData<Int>()
    val observableResult : LiveData<Int> get() = _result

    init {
        viewModelScope.launch {
            delay(5000)
            val random = Random.nextInt(1..100)
            _result.postValue(random)
        }
    }
}