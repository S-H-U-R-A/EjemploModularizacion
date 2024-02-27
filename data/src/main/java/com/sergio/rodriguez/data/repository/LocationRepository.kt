package com.sergio.rodriguez.data.repository

import com.sergio.rodriguez.data.datasource.LocationDataSource
import com.sergio.rodriguez.domain.Location
import java.time.LocalDate

class LocationRepository constructor(
    //private val locationDataSource: LocationDataSource //Inyeccción de dependencias
) {

    //SOLICITAR UNA UBICACIÓN NUEVA
    fun getLocationNetwork(): Location {
        //return locationDataSource.getLocationNetwork()  //Inyeccción de dependencias
        return Location(
            latitude = 72.561155,
            longitude = 7.3589,
            date = LocalDate.now()
        )
    }

    //OBTENER UBICACIONE PEDIDAS
    fun getLocationLocal(): Location {
        //return locationDataSource.getLocationLocal()  //Inyeccción de dependencias
        return Location(
            latitude = 99.561155,
            longitude = 25.3589,
            date = LocalDate.now()
        )
    }

}