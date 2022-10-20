package com.example.weatherapp.data.dataSource.remote

import com.example.weatherapp.data.dataSource.remote.api.ApiService
import com.example.weatherapp.data.model.ForecastResult
import com.example.weatherapp.data.model.WeatherResult
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherRemoteDateSource @Inject constructor(private val apiService: ApiService) :
    IWeatherRemoteDataSource {

    override fun getWeather(city: String, tempType: String): Single<WeatherResult> {
        return apiService.getWeather(city, tempType)
    }

    override fun get7DayForecast(lat: String, lon: String, tempType: String): Single<ForecastResult> {
        return apiService.get7DayForecast(lat, lon, tempType)
    }
}