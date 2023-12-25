package com.fast.weatherinfo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fast.weatherinfo.data.model.WeatherDataEntity
import com.fast.weatherinfo.repository.WeatherDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherDataViewModel @Inject constructor(
    private val weatherDataRepository: WeatherDataRepository
) : ViewModel() {
    private val TAG = "WeatherDataViewModel::"
    private val weatherData: MutableList<WeatherDataEntity> = mutableListOf()

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
                weatherData.add(
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
        }
        .catch { e -> e.printStackTrace() }
        .launchIn(viewModelScope)
}