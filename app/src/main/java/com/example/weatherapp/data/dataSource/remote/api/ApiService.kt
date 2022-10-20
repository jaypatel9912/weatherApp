package com.example.weatherapp.data.dataSource.remote.api

import com.example.weatherapp.data.model.ForecastResult
import com.example.weatherapp.data.model.WeatherResult
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiConstant.WEATHER)
    fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") appid: String = ApiConstant.API_KEY,
    ): Single<WeatherResult>

    @GET(ApiConstant.FORECAST)
    fun get7DayForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String,
        @Query("appid") appid: String = ApiConstant.API_KEY,
    ): Single<ForecastResult>


}