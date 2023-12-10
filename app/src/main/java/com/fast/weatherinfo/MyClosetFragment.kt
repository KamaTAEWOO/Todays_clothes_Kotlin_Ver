package com.fast.weatherinfo

import android.os.Bundle
import android.view.View
import com.fast.weatherinfo.base.BaseFragment
import com.fast.weatherinfo.databinding.FragmentMyClosetBinding

class MyClosetFragment : BaseFragment<FragmentMyClosetBinding>() {

    override fun getFragmentBinding(): FragmentMyClosetBinding =
        FragmentMyClosetBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}