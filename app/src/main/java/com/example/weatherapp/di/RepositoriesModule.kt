package com.example.weatherapp.di

import com.example.weatherapp.data.repositories.authentication.WeatherRepository
import com.example.weatherapp.data.repositories.authentication.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideWeatherRepository(
        repository: WeatherRepositoryImpl
    ): WeatherRepository


}