package com.yugentech.tenki.repositories.location

import android.location.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location?
}