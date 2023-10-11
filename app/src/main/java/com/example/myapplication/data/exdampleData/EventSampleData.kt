package com.example.myapplication.data.exdampleData

import com.example.myapplication.R
import com.example.myapplication.data.dataclasses.EventData
import com.example.myapplication.model.EventModel
import com.example.myapplication.model.MainModel

object EventSampleData {

    val event1 = EventData (
        id = 1,
        eventTitle = "Topspintechno ihr geilen",
        club = "Clubtext",
        veranstalter = "topspintechno",
        cover = EventModel(R.drawable.event1),
        date = "20.10.2023"
    )

    val event2 = EventData (
        id = 2,
        eventTitle = "Topspintechno ihr geilen",
        club = "Clubtext",
        veranstalter = "topspintechno",
        cover = EventModel(R.drawable.event2),
        date = "20.10.2023"
    )

    val event3 = EventData (
        id = 3,
        eventTitle = "Topspintechno ihr geilen",
        club = "Clubtext",
        veranstalter = "topspintechno",
        cover = EventModel(R.drawable.event3),
        date = "20.10.2023"
    )

    val event4 = EventData (
        id = 4,
        eventTitle = "Topspintechno ihr geilen",
        club = "Clubtext",
        veranstalter = "topspintechno",
        cover = EventModel(R.drawable.event4),
        date = "20.10.2023"
    )

    val event5 = EventData (
        id = 5,
        eventTitle = "Topspintechno ihr geilen",
        club = "Clubtext",
        veranstalter = "topspintechno",
        cover = EventModel(R.drawable.event5),
        date = "20.10.2023"
    )

    val event6 = EventData (
        id = 6,
        eventTitle = "Topspintechno ihr geilen",
        club = "Clubtext",
        veranstalter = "topspintechno",
        cover = EventModel(R.drawable.event6),
        date = "20.10.2023"
    )




   /* private val eventModel = listOf(
        EventModel(R.drawable.event1),
        EventModel(R.drawable.event2),
        EventModel(R.drawable.event3),
        EventModel(R.drawable.event4),
        EventModel(R.drawable.event5),
        EventModel(R.drawable.event6)
    )




    val collections = listOf(
        MainModel("Diese Woche", eventModel),
        MainModel("Freitag", eventModel.reversed()),
        MainModel("Samstag", eventModel.shuffled()),
        MainModel("Sonntag", eventModel),
    )

    */
}