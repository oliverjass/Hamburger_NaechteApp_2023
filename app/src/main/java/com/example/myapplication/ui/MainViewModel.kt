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
    val appRepository = AppRepository(LocationApi.retrofitService,dao )                             //bekommt die LocationApi und die Datenbank übergeben
    val cachedLocations: LiveData<List<Locations>> = appRepository.cachedLocations
    val bookmarkedLocations: LiveData<List<Locations>> = appRepository.getBookmarkedLocations()
    private var _location: LiveData<Locations>? = null


    init {                                                                                          // Init block um die repository im viewmodel zu laden // suspend fun
        viewModelScope.launch(Dispatchers.IO){
            appRepository.loadLocationListRepository()
        }
    }


    fun cacheLocation(locations: Locations)  {                                                      // wechselt innerhalb der Coroutine des Dispatcher und versucht eine neue Locationlist zu laden um diese direkt anschließend in die Datenbank zu speichern
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.cacheLocations(locations)
        }
    }

    fun getLocation(locationId: Int): LiveData<Locations> {                                         // wird vom Fragment beobachtet und bestimmt ob ein Ladebalken oder ein Fehlersymbol angezeigt wird
        if (_location == null){
            _location = appRepository.getLocations(locationId)
        }
        return _location!!
    }


    fun loadDetail(locationId: Int): LiveData<Locations> {                                          // Hier werden die daten von den Details der location mit anhand der Apprepository geladen
        return appRepository.getLocation(locationId)
    }


    fun insertLocation(locations: Locations){                                                       // Diese Funktion startet eine Coroutine im ViewModel-Scope, um die Datenbankoperation zum Einfügen oder Aktualisieren eines Standorts asynchron im Hintergrund auszuführen, um die Benutzeroberfläche nicht zu blockieren.
        viewModelScope.launch {
            appRepository.insertLocation(locations)
        }
    }


}




