package com.example.weatherapp.presentation.features.weather

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Forecast
import com.example.weatherapp.presentation.base.BaseFragment

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.screen_weather.*

@AndroidEntryPoint
class WeatherScreen : BaseFragment() {

    private val viewModel: WeatherViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.screen_weather

    override fun initData(data: Bundle?) {

    }

    override fun initViews() {
        switchTemperature.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                temperature.text = "Temperature in Celsius"
            } else {
                temperature.text = "Temperature in Fahrenheit"
            }

            viewModel.getWeather(
                city.text.toString(),
                if (switchTemperature.isChecked) "metric" else "imperial"
            )
        }
    }

    override fun initActions() {
        safetyClickListener.setViewClickSafetyListener(searchWeather) {
            viewModel.getWeather(
                city.text.toString(),
                if (switchTemperature.isChecked) "metric" else "imperial"
            )
        }

        safetyClickListener.setViewClickSafetyListener(forecast) {
            viewModel.getWeather()?.let {
                findNavController().apply {
                    navigate(
                        WeatherScreenDirections.actionWeatherScreenToForecastScreen(
                            Forecast(it.coord?.lat.toString(), it.coord?.lon.toString(), if (switchTemperature.isChecked) "metric" else "imperial")
                        )
                    )
                }
            }
        }
    }

    override fun initObservers() {
        viewModel.liveEvent.observe(viewLifecycleOwner) { event ->
            when (event) {
                is CityError -> {
                    Toast.makeText(requireContext(), "Please enter city", Toast.LENGTH_SHORT).show()
                }
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
            selector = { state -> state.weather }) { weather ->

            weather?.let { it ->
                cityName.text = it.name
                it.main?.let {
                    cityTemp.text =
                        it.temp.toString() + if (switchTemperature.isChecked) " F°" else " C°"
                    humidity.text = "Humidity : " + it.humidity + "%"
                    feelsLike.text = "Feels like : " + it.feels_like + "°"
                }

                it.wind?.let {
                    windSpeed.text = "Wind speed : " + it.speed + " km/h"
                }
            }
        }
    }
}