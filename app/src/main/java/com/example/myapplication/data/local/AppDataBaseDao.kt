package com.example.myapplication.data.local

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.LocationData
import com.example.myapplication.data.model.Locations
import retrofit2.http.GET


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

