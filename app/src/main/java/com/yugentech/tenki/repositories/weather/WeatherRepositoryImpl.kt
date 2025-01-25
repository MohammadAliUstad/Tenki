package com.yugentech.tenki.repositories.weather

import com.yugentech.tenki.data.mappers.toWeatherInfo
import com.yugentech.tenki.data.weather.remote.WeatherApi
import com.yugentech.tenki.util.Resource
import com.yugentech.tenki.data.weather.domain.WeatherInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}