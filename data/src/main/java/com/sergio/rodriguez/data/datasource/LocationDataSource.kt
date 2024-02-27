package com.sergio.rodriguez.data.datasource

import com.sergio.rodriguez.domain.Location


interface LocationDataSource {
    fun getLocationNetwork(): Location
    fun getLocationLocal(): Location
}