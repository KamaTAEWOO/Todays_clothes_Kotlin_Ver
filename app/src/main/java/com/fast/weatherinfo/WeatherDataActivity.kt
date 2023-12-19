package com.fast.weatherinfo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.fast.weatherinfo.base.BaseActivity
import com.fast.weatherinfo.databinding.ActivityWeatherDataBinding
import com.fast.weatherinfo.viewmodel.WeatherDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WeatherDataActivity : BaseActivity<ActivityWeatherDataBinding>() {
    private val TAG = "WeatherDataActivity::"

    private val weatherDataViewModel: WeatherDataViewModel by viewModels()

    override fun getActivityBinding(): ActivityWeatherDataBinding =
        ActivityWeatherDataBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("$TAG::날씨 데이터 파싱")

        initViewModel()
        initBottomNavigation()
    }

    private fun initViewModel() {
        binding.apply {
            lifecycleOwner = this@WeatherDataActivity
            viewModel = weatherDataViewModel
        }
    }

    private fun initBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}