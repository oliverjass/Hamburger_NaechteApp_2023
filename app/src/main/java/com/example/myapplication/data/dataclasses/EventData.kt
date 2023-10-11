package com.example.myapplication.data.dataclasses
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.model.EventModel

@Entity(tableName = "event_table")

data class EventData (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var eventTitle: String,
    var club: String,
    var veranstalter: String,
    var cover: EventModel,
    var date: String
)