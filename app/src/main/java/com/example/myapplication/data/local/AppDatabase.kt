package com.example.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.datamodels.Locations

@Database(entities = [Locations::class], version = 4 )
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: AppDataBaseDao
}

private lateinit var INSTANCE: AppDatabase

                                                                                                    // hier wird eine Datenbank namens location_database erstellt und eine Tabelle aus der Location Klasse erstellt
fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {

            //Neue Datenbank Instanz erstellen
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "location_database"
            )
                .build()
        }
    }
    return INSTANCE
}

