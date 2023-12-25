package com.fast.weatherinfo.repository

import com.fast.weatherinfo.data.response.ResponseWeatherData
import com.fast.weatherinfo.datasource.remote.WeatherDataRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherDataRepositoryImpl @Inject constructor(
    private val weatherDataRemoteDataSource: WeatherDataRemoteDataSource
) : WeatherDataRepository {

    override fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherData> =
        weatherDataRemoteDataSource.requestWeatherData(
            pageNo,
            numOfRows,
            dataType,
            baseDate,
            baseTime,
            nx,
            ny
        )
}