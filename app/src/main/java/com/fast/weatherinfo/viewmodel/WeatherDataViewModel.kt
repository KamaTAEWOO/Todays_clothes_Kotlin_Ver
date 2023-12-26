package com.fast.weatherinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fast.weatherinfo.data.model.WeatherDataEntity
import com.fast.weatherinfo.repository.WeatherDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherDataViewModel @Inject constructor(
    private val weatherDataRepository: WeatherDataRepository
) : ViewModel() {
    private val TAG = "WeatherDataViewModel::"
    private val _weatherData: MutableList<WeatherDataEntity> = mutableListOf()
    val weatherData = _weatherData
    private val _result: MutableLiveData<Boolean> = MutableLiveData(false)
    var result: LiveData<Boolean> = _result

    fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    )
    = weatherDataRepository.requestWeatherData(
        pageNo,
        numOfRows,
        dataType,
        baseDate,
        baseTime,
        nx,
        ny
    )
        .onEach {
            Timber.d("$TAG requestWeatherData() $it")
            for(i in it.response.body.items.item.indices) {
                _weatherData.add(
                    WeatherDataEntity(
                        it.response.body.items.item[i].baseDate,
                        it.response.body.items.item[i].baseTime,
                        it.response.body.items.item[i].category,
                        it.response.body.items.item[i].fcstDate,
                        it.response.body.items.item[i].fcstTime,
                        it.response.body.items.item[i].fcstValue,
                        it.response.body.items.item[i].nx,
                        it.response.body.items.item[i].ny
                    )
                )
            }
            _result.value = true
        }
        .catch { e -> e.printStackTrace() }
        .launchIn(viewModelScope)
}