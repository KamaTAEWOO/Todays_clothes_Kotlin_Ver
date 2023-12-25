package com.fast.weatherinfo.datasource.remote

import com.fast.weatherinfo.api.WeatherDataService
import com.fast.weatherinfo.data.response.ResponseWeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherDataRemoteDataSourceImpl @Inject constructor(
    private val weatherDataService: WeatherDataService
) : WeatherDataRemoteDataSource {
    override fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherData> = flow {
        emit(
            weatherDataService.requestWeatherData(
                pageNo,
                numOfRows,
                dataType,
                baseDate,
                baseTime,
                nx,
                ny
            )
        )
    }
}