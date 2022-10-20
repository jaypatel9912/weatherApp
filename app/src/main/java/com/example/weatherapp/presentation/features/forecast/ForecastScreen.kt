package com.example.weatherapp.presentation.features.forecast

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.screen_forecast.*

@AndroidEntryPoint
class ForecastScreen : BaseFragment() {

    private val viewModel: ForecastViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.screen_forecast

    override fun initData(data: Bundle?) {
        val args = data?.let { _ -> ForecastScreenArgs.fromBundle(data) } ?: return
        viewModel.getForeCast(args.forecast)
    }

    override fun initViews() {
    }

    override fun initActions() {
    }

    override fun initObservers() {
        viewModel.liveEvent.observe(viewLifecycleOwner) { event ->
            when (event) {
                is ApiError -> {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }
        viewModel.store.observe(
            owner = viewLifecycleOwner,
            selector = { state -> state.loading }) { loading ->
            if (loading) showLoading() else hideLoading()
        }

        viewModel.store.observe(
            owner = viewLifecycleOwner,
            selector = { state -> state.forecast }) { forecast ->
            Log.d("", "")
            forecast?.daily?.let {
                val adapter = ForecastAdapter()
                recycler.adapter = adapter
                adapter.submitList(it)
            }
        }
    }
}