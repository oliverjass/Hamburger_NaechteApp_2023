package com.example.myapplication.data.exdampleData

import android.content.ContentValues.TAG
import android.location.Location
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.R
import com.example.myapplication.data.local.AppDataBaseDao
import com.example.myapplication.data.model.LocationData
import com.example.myapplication.data.model.Locations
import com.example.myapplication.data.remote.LocationApi
import com.example.myapplication.data.remote.LocationApiService
import retrofit2.http.GET

class AppRepository(val api: LocationApiService, val dao: AppDataBaseDao) {
    private val _locationIdList = MutableLiveData<List<Int>>()

    val allLocations: LiveData<List<Locations>> = dao.getAllLocations()
    fun getLocations(locationId: Int): LiveData<Locations> = dao.getLocationById(locationId)

    private val _image = MutableLiveData<Locations>()
    val image: LiveData<Locations>
        get() = _image


    suspend fun insertLocation(locations: Locations){
        try {
            dao.insertLocation(locations)
        } catch (ex: Exception){
            //Log.e("Repository","$ex")
        }
    }


    suspend fun loadLocationListRepository(){
        val loadedLocations = api.getLocationsFromAPI()
        Log.d("ApiData","hier ist die location $loadedLocations")
        for( location in loadedLocations){
            insertLocation(location)
        }
        /*insertLocation(loadedLocations)*/


    }



}