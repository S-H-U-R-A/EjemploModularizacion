package com.sergio.rodriguez.domain

import java.time.LocalDate

data class Location(
    val latitude: Double,
    val longitude: Double,
    val date: LocalDate
)