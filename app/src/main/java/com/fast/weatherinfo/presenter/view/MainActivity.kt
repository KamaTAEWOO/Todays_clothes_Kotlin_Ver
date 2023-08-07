package com.fast.weatherinfo.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.fast.weatherinfo.R
import com.fast.weatherinfo.databinding.ActivityMainBinding
import com.fast.weatherinfo.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            viewModel = this@MainActivity
            lifecycleOwner = this@MainActivity
        }
    }
}