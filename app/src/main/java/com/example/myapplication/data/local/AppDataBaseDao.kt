package com.example.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.myapplication.data.datamodels.Locations

@Dao
interface AppDataBaseDao {

    @Query("SELECT * FROM Locations ")
    fun getAllLocations(): LiveData<List<Locations>>                                                //stellt alle Elemente der Location Tabelle als LiveData zur Verfügung

    @Query("SELECT * FROM Locations WHERE locationID = :locationID")                                // Diese Funktion makiert die ids der locations und gibt ein LiveData zurück, das eine oder keine Locations Instanz. enthält, abhängig von der Abfrage ergebnis.
    fun getLocationById(locationID: Int) : LiveData<Locations>                                      // Asynchron, bedeutet aber das die benutzeroberfläche automatisch aktualisiert wird.

    @Query("SELECT * FROM Locations WHERE locationID = :locationID")                                // Diese Funktion makiert die ids der locations und gibt eine Instanz oder null zurück (Synchrone blockierende Methode)
    fun getLocationByIdSync(locationID: Int): Locations?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(locations: Locations)                                                        // speichert eine Liste an locations in die Datenbank falls ein Eintrag mit derselben id existiert wird dieser überschrieben

    @Transaction
    suspend fun upsertLocation(location: Locations) {                                               // Update der locations und wird mit der daten von den locations Synchronisiert
        val existingLocation = getLocationByIdSync(location.locationID)
        if (existingLocation == null) {
            insertLocation(location)
        } else {
            updateLocation(location)
        }
    }

    @Update
    fun updateLocation(location: Locations)                                                         // Funktion für den upsertlocation (überflüssiger code)


    @Query("SELECT * FROM Locations WHERE isBookmarked = 1")                                        // Diese funktion ruft alle Orte aus der Datenbank ab, die als "gebookmarked" markiert sind, und gibt diese als LiveData zurück, was für die Beobachtung von Änderungen in der Benutzeroberfläche nützlich ist.
    fun getBookmarkedLocations(): LiveData<List<Locations>>




}

