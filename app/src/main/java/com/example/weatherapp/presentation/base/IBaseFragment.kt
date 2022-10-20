package com.example.weatherapp.presentation.base

import android.os.Bundle
import com.example.weatherapp.comman.views.SafetyClickListener

interface IBaseFragment {

    val baseActivity: BaseActivity?

    val safetyClickListener: SafetyClickListener

    fun getLayoutId(): Int

    fun initData(data: Bundle?)

    fun initViews()

    fun initActions()

    fun initObservers()

    fun onBackPressed()

    fun showLoading()

    fun hideLoading()



}