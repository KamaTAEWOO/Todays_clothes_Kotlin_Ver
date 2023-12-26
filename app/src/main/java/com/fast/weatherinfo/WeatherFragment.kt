package com.fast.weatherinfo

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.fast.weatherinfo.base.BaseFragment
import com.fast.weatherinfo.databinding.FragmentWeatherBinding
import com.fast.weatherinfo.viewmodel.WeatherDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WeatherFragment : BaseFragment<FragmentWeatherBinding>() {

    private val TAG = "WeatherFragment::"
    private lateinit var weatherDataViewModel: WeatherDataViewModel

    override fun getFragmentBinding(): FragmentWeatherBinding =
        FragmentWeatherBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")

        var data = ""
        weatherDataViewModel.result.observe(viewLifecycleOwner) {
            val result = it
            Timber.d("$TAG::result.observe() $result")
            if(result) {
                weatherDataViewModel.weatherData.forEach {
                    data += it.toString() + "\n"
                }

                binding.textView.text = data
            } else {
                binding.textView.text = "데이터 없음"
            }
        }

        /**
         * Refresh
         * */
        binding.swipeRefreshLayout.setOnRefreshListener {}
    }

    private fun initViewModel() {
        Timber.i("$TAG::initViewModel()")
        weatherDataViewModel = ViewModelProvider(requireActivity())[WeatherDataViewModel::class.java]
    }



}