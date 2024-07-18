package com.plcoding.weatherapp.di

import com.plcoding.weatherapp.data.remote.location.DefaultLocationTracker
import com.plcoding.weatherapp.data.remote.repository.WeatherRepositoryImple
import com.plcoding.weatherapp.domain.location.LocationTracker
import com.plcoding.weatherapp.domain.repositry.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImple: WeatherRepositoryImple): WeatherRepository

}