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
    fun getAllLocations(): LiveData<List<Locations>>

    @Query("SELECT * FROM Locations WHERE locationID = :locationID")
    fun getLocationById(locationID: Int) : LiveData<Locations>

    @Query("SELECT * FROM Locations WHERE locationID = :locationID")
    fun getLocationByIdSync(locationID: Int): Locations?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(locations: Locations)

    @Transaction
    suspend fun upsertLocation(location: Locations) {
        val existingLocation = getLocationByIdSync(location.locationID)
        if (existingLocation == null) {
            insertLocation(location)
        } else {
            updateLocation(location)
        }
    }

    @Update
    fun updateLocation(location: Locations)


    @Query("SELECT * FROM Locations")
    fun saveLocation(): LiveData<Locations>

    @Query("UPDATE Locations SET isBookmarked = :isBookmarked WHERE locationID = :locationID")
    fun updateBookmarkStatus(locationID: Int, isBookmarked: Boolean)


    @Query("SELECT * FROM Locations WHERE isBookmarked = 1")
    fun getBookmarkedLocations(): LiveData<List<Locations>>






}

