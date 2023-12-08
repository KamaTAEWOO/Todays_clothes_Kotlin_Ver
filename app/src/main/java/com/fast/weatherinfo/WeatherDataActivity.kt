package com.fast.weatherinfo

import android.os.Bundle
import com.fast.weatherinfo.base.BaseActivity
import com.fast.weatherinfo.databinding.ActivityWeatherDataBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WeatherDataActivity : BaseActivity<ActivityWeatherDataBinding>() {
    private val TAG = "WeatherDataActivity::"

    override fun getActivityBinding(): ActivityWeatherDataBinding =
        ActivityWeatherDataBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("$TAG::날씨 데이터 파싱")
    }
}