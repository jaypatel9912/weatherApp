package com.example.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Forecast(val lat: String, val lon: String, val temp: String): java.io.Serializable