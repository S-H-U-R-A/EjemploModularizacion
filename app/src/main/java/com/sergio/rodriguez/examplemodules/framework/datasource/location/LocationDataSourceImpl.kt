package com.sergio.rodriguez.examplemodules.framework.datasource.location

import com.sergio.rodriguez.data.datasource.LocationDataSource
import com.sergio.rodriguez.domain.Location
import java.time.LocalDate

class LocationDataSourceImpl(
    //private val room: String //Inyección de dependencias
) : LocationDataSource {

    override fun getLocationNetwork(): Location = Location(
        latitude = 72.561155,
        longitude = 7.3589,
        date = LocalDate.now()
    )

    override fun getLocationLocal(): Location = Location(
        latitude = 99.561155,
        longitude = 25.3589,
        date = LocalDate.now()
    )

}