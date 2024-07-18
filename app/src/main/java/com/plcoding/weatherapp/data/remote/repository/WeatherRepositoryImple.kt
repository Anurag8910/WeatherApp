package com.plcoding.weatherapp.data.remote.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.plcoding.weatherapp.data.remote.WeatherApi
import com.plcoding.weatherapp.data.remote.mappers.toWeatherInfo
import com.plcoding.weatherapp.domain.repositry.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImple @Inject constructor(
    private val api:WeatherApi
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}