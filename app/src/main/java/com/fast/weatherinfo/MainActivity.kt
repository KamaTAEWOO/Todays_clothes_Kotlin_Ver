package com.fast.weatherinfo

import android.content.Intent
import android.os.Bundle
import com.fast.weatherinfo.base.BaseActivity
import com.fast.weatherinfo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val TAG = "MainActivity::"

    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * 앱 시작
         * */
        Timber.d("$TAG::앱 시작")
        startActivity(Intent(this, WeatherDataActivity::class.java))
    }
}