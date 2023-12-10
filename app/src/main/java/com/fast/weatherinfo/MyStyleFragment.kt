package com.fast.weatherinfo

import android.os.Bundle
import android.view.View
import com.fast.weatherinfo.base.BaseFragment
import com.fast.weatherinfo.databinding.FragmentMyStyleBinding

class MyStyleFragment : BaseFragment<FragmentMyStyleBinding>() {

    override fun getFragmentBinding(): FragmentMyStyleBinding =
        FragmentMyStyleBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}