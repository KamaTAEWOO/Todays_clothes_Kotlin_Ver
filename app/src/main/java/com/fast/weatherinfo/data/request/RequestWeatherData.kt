package com.fast.weatherinfo.data.request

import com.fast.weatherinfo.BuildConfig

data class RequestWeatherData(
    val serviceKey: String = BuildConfig.API_KEY,
    val pageNo: Int = 1,
    val numOfRows: Int = 1000,
    val dataType: String = "JSON",
    val baseDate: String = "20231224",
    val baseTime: String = "0500",
    val nx: String = "55",
    val ny: String = "127"
)
