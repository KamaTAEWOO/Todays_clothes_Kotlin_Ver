package com.fast.weatherinfo.repository

import com.fast.weatherinfo.data.response.ResponseWeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherDataRepository {

    fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherData>
}