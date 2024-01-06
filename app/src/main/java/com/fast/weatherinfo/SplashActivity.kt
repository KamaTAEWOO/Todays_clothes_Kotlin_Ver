package com.fast.weatherinfo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.fast.weatherinfo.base.BaseActivity
import com.fast.weatherinfo.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    private val TAG = "SplashActivity::"

    override fun getActivityBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3초 후에 Intent 실행
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, WeatherDataActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onBackPressed() {}
}