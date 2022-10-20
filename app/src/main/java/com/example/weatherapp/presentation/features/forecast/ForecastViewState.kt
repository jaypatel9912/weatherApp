package com.example.weatherapp.presentation.features.forecast

import com.example.weatherapp.data.model.ForecastResult

data class ForecastViewState(var loading: Boolean, var forecast: ForecastResult?)
