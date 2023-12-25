package com.fast.weatherinfo.api

import com.fast.weatherinfo.BuildConfig
import com.fast.weatherinfo.data.response.ResponseWeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherDataService {

    @GET("getVilageFcst?serviceKey=" + BuildConfig.API_KEY)
    suspend fun requestWeatherData(
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("dataType") dataType: String,
        @Query("base_date") baseDate: String,
        @Query("base_time") baseTime: String,
        @Query("nx") nx: String,
        @Query("ny") ny: String
    ): ResponseWeatherData
}