package com.sergio.rodriguez.domain.usecases

import com.sergio.rodriguez.domain.Location
import java.time.LocalDate

class GetLocationNetworkUseCase(
    //private val repository: LocationRepository // Inyección de dependencias
) {

    suspend operator fun invoke(): Location {
        return Location(
            latitude = 72.561155,
            longitude = 7.3589,
            date = LocalDate.now()
        )
    }

}