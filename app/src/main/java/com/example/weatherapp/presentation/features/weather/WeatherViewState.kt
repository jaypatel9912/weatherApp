package com.example.weatherapp.presentation.features.weather

import com.example.weatherapp.data.model.WeatherResult

data class WeatherViewState(var loading: Boolean, var weather: WeatherResult?)
