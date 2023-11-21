package com.example.myapplication.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.data.local.AppDataBaseDao
import com.example.myapplication.data.remote.LocationApiService
import com.example.myapplication.data.datamodels.Locations

class AppRepository(val api: LocationApiService, val dao: AppDataBaseDao) {
    val cachedLocations: LiveData<List<Locations>> = dao.getAllLocations()                          //stellt alle Elemente der LocationDatabase als LiveData zur Verfügung

    fun getLocations(locationId: Int): LiveData<Locations> = dao.getLocationById(locationId)


    fun getBookmarkedLocations(): LiveData<List<Locations>> {                                       // um alle favorisierten Locations aus der Datenbank abzurufen
        return dao.getBookmarkedLocations()
    }


                                                                                                    // eine funktion Um alle locations in einer Datenbank einzufügen. mithilfe von catchBlock wird der versuch herbeigerufen ob sie vorhanden ist und bei einer fehlermeldung wird mit der Log.e im logcat angezeigt.
    fun insertLocation(locations: Locations){
        try {
            dao.insertLocation(locations)
        } catch (e: Exception){
            Log.e("Error Loading Data","$e")
        }
    }

    fun cacheLocations(locations: Locations) {                                                      // Funktion des Caching mit einer try catch mit einer Log protokoll falls der der cache nicht stattgefunden hat oder nicht verfügbar ist
        try {
            dao.insertLocation(locations)
        } catch (ex: Exception) {
            Log.e("AppRepository","Cannot Find cache list of $ex")
        }
    }



                                                                                                    // Funktion gibt diese liveData objekt zurück aus einer datenbank.Dies ermöglicht eine reaktive Aktualisierung der Benutzeroberfläche, wenn sich der abgefragte Standort in der Datenbank ändert.
    fun getLocation(locationId: Int): LiveData<Locations> {
        return dao.getLocationById(locationId)
    }



                                                                                                    // Diese Funktion lädt die LocationDaten der Api.protokolliert sie für Debug-Zwecke und fügt sie dann in die Datenbank ein. Der Einsatz von Coroutinen (suspend-Funktion) weist darauf hin, dass dieser Vorgang asynchron ist und wahrscheinlich in einem Hintergrund-Thread stattfindet, um die Benutzeroberfläche nicht zu blockieren
    suspend fun loadLocationListRepository(){
        val loadedLocations = api.getLocationsFromAPI()
        Log.d("ApiData","hier ist die location $loadedLocations")
        for( location in loadedLocations){
            insertLocation(location)
        }
    }


    // TODO Hier noch kommentieren


                                                                                                    // Eine klasse mit zwei überschreibenen funktionen um die Items sich zu unterscheiden sobald die im favoriten makiert und gelöscht werden. jedoch ist dieser code ausgeblendet, da sie bereits im

    class LocationDiffUtil : DiffUtil.ItemCallback<Locations>() {
        override fun areItemsTheSame(oldItem: Locations, newItem: Locations): Boolean {
            return oldItem.locationID == newItem.locationID
        }

        override fun areContentsTheSame(oldItem: Locations, newItem: Locations): Boolean {
            return oldItem == newItem
        }
    }




}






