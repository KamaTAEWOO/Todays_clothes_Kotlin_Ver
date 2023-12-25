package com.fast.weatherinfo.viewmodel

import androidx.lifecycle.ViewModel
import com.fast.weatherinfo.repository.WeatherDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class WeatherDataViewModel @Inject constructor(
    private val weatherDataRepository: WeatherDataRepository
) : ViewModel() {

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
        .catch { e -> e.printStackTrace() }
}