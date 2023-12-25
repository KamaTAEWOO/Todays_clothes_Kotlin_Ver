package com.fast.weatherinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.fast.weatherinfo.base.BaseFragment
import com.fast.weatherinfo.databinding.FragmentWeatherBinding
import com.fast.weatherinfo.util.WeatherUtil
import com.fast.weatherinfo.viewmodel.WeatherDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class WeatherFragment : BaseFragment<FragmentWeatherBinding>() {

    private val TAG = "WeatherFragment::"
    private val weatherDataViewModel: WeatherDataViewModel by viewModels()

    override fun getFragmentBinding(): FragmentWeatherBinding =
        FragmentWeatherBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")

        /**
         * Refresh
         * */
        binding.swipeRefreshLayout.setOnRefreshListener {}
    }



}