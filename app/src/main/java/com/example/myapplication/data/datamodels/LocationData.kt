package com.example.myapplication.data.datamodels

import com.squareup.moshi.Json


data class LocationData (
    @Json (name = "locationID")
    val allLocationIds: List<Locations> = listOf()
)