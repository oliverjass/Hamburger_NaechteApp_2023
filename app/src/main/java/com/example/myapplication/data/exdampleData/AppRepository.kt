package com.example.myapplication.data.exdampleData

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.R
import com.example.myapplication.data.dataclasses.EventData
import com.example.myapplication.data.model.EventModel
import com.example.myapplication.data.model.Locations

class AppRepository {




    /*
    val events: List<EventData>
        get() {
            return loadEvents()
        }

     */

    //region Datasource
    private fun loadEvents(): List<EventData> {
        return listOf(
            EventData (
                id = 1,
                eventTitle = "Topspintechno ihr geilen",
                club = "Clubtext",
                veranstalter = "topspintechno",
                cover = EventModel(R.drawable.event1),
                date = "20.10.2023"
            ),
            EventData(
                id = 2,
                eventTitle = "Topspintechno ihr geilen",
                club = "Clubtext",
                veranstalter = "topspintechno",
                cover = EventModel(R.drawable.event2),
                date = "20.10.2023"
            ),
            EventData (
                id = 3,
                eventTitle = "Topspintechno ihr geilen",
                club = "Clubtext",
                veranstalter = "topspintechno",
                cover = EventModel(R.drawable.event3),
                date = "20.10.2023"
            ),
            EventData (
                id = 4,
                eventTitle = "Topspintechno ihr geilen",
                club = "Clubtext",
                veranstalter = "topspintechno",
                cover = EventModel(R.drawable.event4),
                date = "20.10.2023"
            ),
            EventData (
                id = 5,
                eventTitle = "Topspintechno ihr geilen",
                club = "Clubtext",
                veranstalter = "topspintechno",
                cover = EventModel(R.drawable.event5),
                date = "20.10.2023"
            ),
            EventData (
                id = 6,
                eventTitle = "Topspintechno ihr geilen",
                club = "Clubtext",
                veranstalter = "topspintechno",
                cover = EventModel(R.drawable.event6),
                date = "20.10.2023"
            )
        )
    }

    fun loadLoactions(): List<Locations>{

        val locations = listOf(
            Locations(R.string.locationName1,R.string.club, R.drawable.baalsal,false),
            Locations(R.string.locationName2,R.string.club, R.drawable.docks,false),
            Locations(R.string.locationName3,R.string.club, R.drawable.frau_holle,false),
            Locations(R.string.locationName4,R.string.bar, R.drawable.berliner_betrueger,true),
            Locations(R.string.locationName5,R.string.club, R.drawable.fundbuero,false),
            Locations(R.string.locationName6,R.string.bar, R.drawable.turmbar,true),
            Locations(R.string.locationName7,R.string.bar, R.drawable.clockers,true),
            Locations(R.string.locationName8,R.string.club,R.drawable.waagennbau,false),
            Locations(R.string.locationName9,R.string.club, R.drawable.ubel_und_gefaehrlich,false),
            Locations(R.string.locationName10,R.string.club, R.drawable.nikki_tiger,false),
            Locations(R.string.locationName11,R.string.bar, R.drawable.katze,true),
            Locations(R.string.locationName12,R.string.club, R.drawable.edelfettwerk,false),
            Locations(R.string.locationName13,R.string.club, R.drawable.dot,false),
            Locations(R.string.locationName14,R.string.bar, R.drawable.astra_stube,true),
            Locations(R.string.locationName15,R.string.bar, R.drawable.goldfischglas,true),
            Locations(R.string.locationName16,R.string.club, R.drawable.pal,false),
            Locations(R.string.locationName17,R.string.club,R.drawable.suedpol,false)
        )
        return locations
    }
    // endregion

    fun loadBars(): List<Locations>{
        return loadLoactions().filter { it.isBar }
    }

    fun loadClubs(): List<Locations>{
        return loadLoactions().filter { !it.isBar }
    }
}