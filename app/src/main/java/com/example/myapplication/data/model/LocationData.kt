package com.example.myapplication.data.model

import androidx.room.Entity
import com.squareup.moshi.Json


data class LocationData (
    @Json (name = "locationID")
    val allLocationIds: List<Locations> = listOf()
)