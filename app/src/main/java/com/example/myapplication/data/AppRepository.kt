package com.example.myapplication.data

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.data.local.AppDataBaseDao
import com.example.myapplication.data.remote.LocationApiService
import com.example.myapplication.data.datamodels.Locations

class AppRepository(val api: LocationApiService, val dao: AppDataBaseDao) {

    val cachedLocations: LiveData<List<Locations>> = dao.getAllLocations()
    private val _locationIdList = MutableLiveData<List<Int>>()
    private val _image = MutableLiveData<Locations>()
    val image: LiveData<Locations> get() = _image

    fun getLocations(locationId: Int): LiveData<Locations> = dao.getLocationById(locationId)


    fun markLocationAsFavorite(locationID: Int) {
        // Hier wird die DAO-Methode aufgerufen, um den isBookmarked-Status zu aktualisieren
        dao.updateBookmarkStatus(locationID, true)
    }

    // Beispiel, um alle favorisierten Locations aus der Datenbank abzurufen
    fun getBookmarkedLocations(): LiveData<List<Locations>> {
        return dao.getBookmarkedLocations()
    }




    suspend fun insertLocation(locations: Locations){
        try {
            dao.insertLocation(locations)
        } catch (ex: Exception){
            Log.e("Repository","$ex")
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
    class LocationDiffUtil : DiffUtil.ItemCallback<Locations>() {
        override fun areItemsTheSame(oldItem: Locations, newItem: Locations): Boolean {
            return oldItem.locationID == newItem.locationID
        }

        override fun areContentsTheSame(oldItem: Locations, newItem: Locations): Boolean {
            return oldItem == newItem
        }
    }



    suspend fun cacheLocations(locations: Locations) {
        try {
            dao.insertLocation(locations)
        } catch (ex: Exception) {
            Log.e("AppRepository","Cannot Find cache list of Locations")
        }
    }


    suspend fun toggleFavorite(locationId: Int){

/*        var location = getLocation(locationId).value!!
        location.isBookmarked = !location.isBookmarked
        insertLocation(location)*/
    }


    fun getLocation(locationId: Int): LiveData<Locations> {
        return dao.getLocationById(locationId)
    }

}

/*    suspend fun loadLocationDetails(locationId: Int) {
        try {
            val loadedLocation = api.getLocationsFromAPI(locationId)
            insertLocation(loadedLocation)
        } catch (ex: Exception) {
            Log.e("Repository", "Fehler beim Laden von Location-Details: $ex")
        }
    }*/



