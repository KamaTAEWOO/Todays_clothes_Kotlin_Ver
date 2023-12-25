package com.fast.weatherinfo.data.model

//Item(baseDate=20231224, baseTime=0500, category=VVV, fcstDate=20231226, fcstTime=1900, fcstValue=-1.7, nx=55, ny=127)
data class WeatherDataEntity(
    val baseDate: String,
    val baseTime: String,
    val category: String,
    val fcstDate : String,
    val fcstTime : String,
    val fcstValue : String,
    val nx : Int,
    val ny : Int
)
