package com.example.weatherapp.di

import com.example.weatherapp.data.dataSource.remote.WeatherRemoteDateSource
import com.example.weatherapp.data.dataSource.remote.IWeatherRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun providerWeatherRemoteDateSource(
        weatherRemoteDateSource: WeatherRemoteDateSource
    ): IWeatherRemoteDataSource


}