package com.example.myapplication.data.remote

import com.example.myapplication.data.datamodels.Locations
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val BASE_URL = "https://public.syntax-institut.de/apps/batch9/OliverJass/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface LocationApiService {
    @GET("locations.json")
    suspend fun getLocationsFromAPI(): List<Locations>

}

object LocationApi {
    val retrofitService: LocationApiService by lazy { retrofit.create(LocationApiService::class.java) }
}