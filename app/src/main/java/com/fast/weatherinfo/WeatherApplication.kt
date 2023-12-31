package com.fast.weatherinfo

import android.app.Application
import com.fast.weatherinfo.util.WeatherDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Hilt Application 필요
 */
@HiltAndroidApp
class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(WeatherDebugTree())
        }
    }
}