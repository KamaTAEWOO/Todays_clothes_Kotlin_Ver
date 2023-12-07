package com.fast.weatherinfo

import android.os.Bundle
import com.eduforall.eduforall_launcher_app.base.BaseActivity
import com.fast.weatherinfo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //startActivity(Intent(this, AppUpdateActivity::class.java))
    }
}