package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.dataclasses.EventData
import com.example.myapplication.data.exdampleData.AppRepository
import com.example.myapplication.data.model.Locations

class MainViewModel: ViewModel() {
    private val appRepository = AppRepository()

    // _locations soll in der RV gefiltert angezeigt werden
    private val _locations: MutableLiveData<List<Locations>> = MutableLiveData()
    val locations: LiveData<List<Locations>>
        get() = _locations

    // allLocations ungefiltert
    val allLocations = appRepository.loadLoactions()

    fun getLocationByName(locationName: Int): Locations{
        // Die funktion braucht zugriff aller locations -  val alllocations
        // Brauch einen Location name nachdem er gesucht wird - locationName

        val locationName = allLocations.get(Locations())
        return locationName
        // er soll die location zurückgeben gebündelt von typ Location
    }


    //Update zur LiveData
    fun selectAll(){
    }
    fun selectBars() {
        _locations.postValue(allLocations.filter { it.isBar })
    }

    fun selectClubs():List<Locations> {
        _locations.postValue(allLocations.filter { it.isBar })
    }


    init {
        _locations.postValue(appRepository.loadLoactions())
    }



}