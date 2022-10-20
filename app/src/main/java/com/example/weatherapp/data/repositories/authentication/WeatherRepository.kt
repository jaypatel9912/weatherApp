package com.example.weatherapp.data.repositories.authentication

import com.example.weatherapp.data.model.ForecastResult
import com.example.weatherapp.data.model.WeatherResult
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {

    fun getWeather(city: String, tempType: String): Single<WeatherResult>

    fun get7DayForecast(lat: String, lon: String, tempType: String): Single<ForecastResult>

}