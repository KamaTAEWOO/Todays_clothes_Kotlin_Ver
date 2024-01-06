package com.fast.weatherinfo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.fast.weatherinfo.base.BaseActivity
import com.fast.weatherinfo.databinding.ActivityWeatherDataBinding
import com.fast.weatherinfo.util.WeatherUtil
import com.fast.weatherinfo.viewmodel.WeatherDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class WeatherDataActivity : BaseActivity<ActivityWeatherDataBinding>() {
    private val TAG = "WeatherDataActivity::"
    private val weatherDataViewModel: WeatherDataViewModel by viewModels()

    override fun getActivityBinding(): ActivityWeatherDataBinding =
        ActivityWeatherDataBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initBottomNavigation()
    }

    private fun init() {
        Timber.i("$TAG::init()")

        if(weatherDataViewModel.weatherData.isEmpty()) {
            WeatherUtil.getTodayDate()
            getWeatherData()
        }
    }

    private fun initBottomNavigation() {
        Timber.i("$TAG::initBottomNavigation()")
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    /**
     * Item(baseDate=20231224, baseTime=0500, category=VVV, fcstDate=20231226, fcstTime=1900, fcstValue=-1.7, nx=55, ny=127)
     * */
    private fun getWeatherData() {
        Timber.i("$TAG::getWeatherData()")

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                weatherDataViewModel.requestWeatherData(
                    WeatherUtil.PAGE_NO,
                    WeatherUtil.NUM_OF_ROWS,
                    WeatherUtil.DATA_TYPE,
                    WeatherUtil.BASE_DATE,
                    WeatherUtil.BASE_TIME,
                    WeatherUtil.NX,
                    WeatherUtil.NY
                )
            }
        }
    }

    override fun onBackPressed() {}
}