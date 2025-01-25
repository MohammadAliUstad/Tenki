package com.yugentech.tenki.data.weather.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDto(
    val latitude: Double,
    val longitude: Double,
    @Json(name = "generationtime_ms")
    val generationTimeMs: Double,
    @Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int,
    val timezone: String,
    @Json(name = "timezone_abbreviation")
    val timezoneAbbreviation: String,
    val elevation: Double,
    @Json(name = "hourly_units")
    val hourlyUnits: HourlyUnits,
    val hourly: HourlyDto
)

@JsonClass(generateAdapter = true)
data class HourlyUnits(
    val time: String,
    @Json(name = "temperature_2m")
    val temperature: String,
    val weathercode: String,
    @Json(name = "relativehumidity_2m")
    val relativeHumidity: String,
    @Json(name = "windspeed_10m")
    val windSpeed: String,
    @Json(name = "pressure_msl")
    val pressure: String
)

@JsonClass(generateAdapter = true)
data class HourlyDto(
    val time: List<String>,
    @Json(name = "temperature_2m")
    val temperatures: List<Double>,
    val weathercode: List<Int>,
    @Json(name = "relativehumidity_2m")
    val humidities: List<Double>,
    @Json(name = "windspeed_10m")
    val windSpeeds: List<Double>,
    @Json(name = "pressure_msl")
    val pressures: List<Double>
)