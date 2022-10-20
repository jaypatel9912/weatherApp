package com.example.weatherapp.presentation.features.weather

sealed class LoginEvent

object CityError : LoginEvent()

object ApiError : LoginEvent()