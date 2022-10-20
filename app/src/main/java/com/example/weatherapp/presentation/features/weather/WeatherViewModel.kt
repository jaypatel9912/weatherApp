package com.example.weatherapp.presentation.features.weather

import com.example.cleancoderxjava.comman.rxjava.applyIO
import com.example.weatherapp.data.model.WeatherResult
import com.example.weatherapp.data.repositories.authentication.WeatherRepository
import com.example.weatherapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    BaseViewModel<WeatherViewState, LoginEvent>() {

    override fun initState(): WeatherViewState = WeatherViewState(loading = false, null)

    fun getWeather(): WeatherResult? {
        return currentState.weather
    }

    fun getWeather(city: String, tempType: String) {
        if (city.isEmpty()) {
            dispatchEvent(CityError)
            return
        }
        dispatchState(currentState.copy(loading = true))
        weatherRepository.getWeather(city, tempType)
            .applyIO()
            .doFinally { dispatchState(currentState.copy(loading = false)) }
            .subscribe(
                {
                    dispatchState(currentState.copy(weather = it))
                },
                { error ->
                    dispatchEvent(ApiError)
                },
            )
    }

}