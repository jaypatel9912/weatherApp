package com.example.weatherapp.presentation.features.forecast

sealed class ForecastEvent

object ApiError : ForecastEvent()
