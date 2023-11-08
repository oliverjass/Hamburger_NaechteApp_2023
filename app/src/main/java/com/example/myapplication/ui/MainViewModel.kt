package com.example.myapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.exdampleData.AppRepository
import com.example.myapplication.data.local.getDatabase
import com.example.myapplication.data.model.Locations
import com.example.myapplication.data.remote.LocationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    val dao = getDatabase(app).dao
    val appRepository = AppRepository(LocationApi.retrofitService,dao )


    // _locations soll in der RV gefiltert angezeigt werden
    private val _locations: MutableLiveData<List<Locations>> = MutableLiveData()
    val allLocations: LiveData<List<Locations>> = appRepository.locationsList

    fun getLocation(locationId: Int): LiveData<Locations> = appRepository.getLocations(locationId)
    init {
        loadLocationListVM()
    }

    fun loadLocationListVM(){
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.loadLocationListRepository()
        }
    }


    val locations = appRepository.locationsList

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



}