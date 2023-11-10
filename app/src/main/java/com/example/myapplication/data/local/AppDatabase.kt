package com.example.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.model.Locations

@Database(entities = [Locations::class], version = 4 )
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: AppDataBaseDao
}

private lateinit var INSTANCE: AppDatabase

// if there's no Database a new one is built
fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {

            //Neue Datenbank Instanz erstellen
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            )
                .build()
        }
    }
    return INSTANCE
}

