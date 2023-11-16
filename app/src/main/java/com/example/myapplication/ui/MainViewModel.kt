package com.example.myapplication.ui

import android.app.Application
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.AppRepository
import com.example.myapplication.data.datamodels.Locations
import com.example.myapplication.data.local.getDatabase
import com.example.myapplication.data.remote.LocationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    val dao = getDatabase(app).dao
    val appRepository = AppRepository(LocationApi.retrofitService,dao )
    val cachedLocations: LiveData<List<Locations>> = appRepository.cachedLocations
/*    private lateinit var bookmarkedLocations: LiveData<List<Locations>>*/
    val bookmarkedLocations: LiveData<List<Locations>> = appRepository.getBookmarkedLocations()
    private var _location: LiveData<Locations>? = null


    init {
        viewModelScope.launch(Dispatchers.IO){
            appRepository.loadLocationListRepository()
        }
    }


    fun cacheLocation(locations: Locations)  {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.cacheLocations(locations)
        }
    }

    fun cacheLocations(locations: Locations) {
        viewModelScope.launch (Dispatchers.IO){
            appRepository.cacheLocations(locations)
        }
    }


    fun getLocation(locationId: Int): LiveData<Locations> {
        if (_location == null){
            _location = appRepository.getLocations(locationId)
        }
        return _location!!
    }



    fun loadLocationListVM(locationId: Int): LiveData<Locations> {
        viewModelScope.launch(Dispatchers.IO) {
            _location = appRepository.getLocations(locationId)

        }
        return appRepository.getLocation(locationId)
    }


    fun markLocationAsFavorite(locationID: Int) {
        viewModelScope.launch {
            appRepository.markLocationAsFavorite(locationID)
        }
    }




    fun loadLocationDetailsVM(locationId: Int): LiveData<Locations> {
        return appRepository.getLocation(locationId)
    }


    fun insertLocation(locations: Locations){
        viewModelScope.launch {
            appRepository.insertLocation(locations)
        }
    }

    fun toggleFavorite(locationId: Int){
        viewModelScope.launch {
            appRepository.toggleFavorite(locationId)
        }
    }
}






    // allLocations ungefiltert



    //val allLocations = appRepository.loadLoactions()
    /*fun getLocationByName(locationName: Int): Locations?{
        // Die funktion braucht zugriff aller locations -  val alllocations
        // Brauch einen Location name nachdem er gesucht wird - locationName

        val locationName = allLocations.find { it.data == locations }
        return
        // er soll die location zurückgeben gebündelt von typ Location
    }

     */


    //Update zur LiveData
/*    fun selectAll(){
        _locations.postValue(allLocations)
    }
    fun selectBars() {
        _locations.postValue(allLocations.filter { it.isBar })
    }

    fun selectClubs():List<Locations> {
         _locations.postValue(allLocations.filter { it.isBar })
        return selectClubs()
    }

    init {
        _locations.postValue(appRepository.loadLoactions())
    }*/


/*    init {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.loadLocationListRepository()
        }
    }*/



