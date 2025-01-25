package com.yugentech.tenki.repositories.weather

import com.yugentech.tenki.util.Resource
import com.yugentech.tenki.data.weather.domain.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(
        lat: Double,
        long: Double
    ): Resource<WeatherInfo>
}