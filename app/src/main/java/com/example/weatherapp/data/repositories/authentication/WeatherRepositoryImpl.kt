package com.example.weatherapp.data.repositories.authentication

import com.example.weatherapp.data.dataSource.remote.IWeatherRemoteDataSource
import com.example.weatherapp.data.model.ForecastResult
import com.example.weatherapp.data.model.WeatherResult
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherRepository: IWeatherRemoteDataSource) :
    WeatherRepository {

    override fun getWeather(city: String, tempType: String): Single<WeatherResult> {
        return weatherRepository.getWeather(city, tempType)
    }

    override fun get7DayForecast(lat: String, lon: String, tempType: String): Single<ForecastResult> {
        return weatherRepository.get7DayForecast(lat, lon, tempType)
    }
}

