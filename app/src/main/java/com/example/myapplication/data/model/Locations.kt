package com.example.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Locations (
    @Json(name = "locationID")
    @PrimaryKey
    val locationID: Int,
    @Json(name = "locationName")
    val locationName: String,
    @Json(name = "locationArt")
    val locationArt: String,
    @Json(name = "locationDescription")
    val locationDescription: String
    //@Json(name = "isBar")
    //val isBar: Boolean




)
