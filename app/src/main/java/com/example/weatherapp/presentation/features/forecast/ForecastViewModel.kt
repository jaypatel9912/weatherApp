package com.example.weatherapp.presentation.features.forecast

import com.example.cleancoderxjava.comman.rxjava.applyIO
import com.example.weatherapp.data.model.Forecast
import com.example.weatherapp.data.repositories.authentication.WeatherRepository
import com.example.weatherapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    BaseViewModel<ForecastViewState, ForecastEvent>() {

    override fun initState(): ForecastViewState = ForecastViewState(loading = false, null)

    fun getForeCast(forecast: Forecast) {
        dispatchState(currentState.copy(loading = true))
        weatherRepository.get7DayForecast(forecast.lat, forecast.lon, forecast.temp)
            .applyIO()
            .doFinally { dispatchState(currentState.copy(loading = false)) }
            .subscribe(
                {
                    dispatchState(currentState.copy(forecast = it))
                },
                {
                    dispatchEvent(ApiError)
                },
            )
    }

}
