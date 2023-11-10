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
    val locationDescription: String,
    @Json(name = "music")
    val locationMusic: String,
    @Json(name = "adress")
    val adress: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "openingHours")
    val openingHours: String,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "phoneNr")
    val phoneNr: String,
    @Json(name = "webLink")
    val webLink: String,
    @Json(name = "imageResource")
    val imageResource: String

/*    @Json(name = "imageResource")
    val imageResource: String*/
    //@Json(name = "isBar")
    //val isBar: Boolean




)
