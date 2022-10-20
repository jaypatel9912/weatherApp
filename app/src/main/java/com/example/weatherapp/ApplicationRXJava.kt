package com.example.weatherapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.rxjava3.internal.functions.Functions
import io.reactivex.rxjava3.plugins.RxJavaPlugins

@HiltAndroidApp
class ApplicationRXJava : Application() {
    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler(Functions.emptyConsumer())
    }
}