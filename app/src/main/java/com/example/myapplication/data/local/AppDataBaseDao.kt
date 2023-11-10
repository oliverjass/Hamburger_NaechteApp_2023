package com.example.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.datamodels.Locations

@Dao
interface AppDataBaseDao {

    @Query("SELECT * FROM Locations ")
    fun getAllLocations(): LiveData<List<Locations>>

    @Query("SELECT * FROM Locations WHERE locationID =:locationID")
    fun getLocationById(locationID: Int) : LiveData<Locations>

/*    @GET("locations")
    suspend fun getAllLocationIds(): LocationData*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(locations: Locations)
}

