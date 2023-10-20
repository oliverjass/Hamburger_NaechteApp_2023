package com.example.myapplication.data

import android.content.Context
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.data.model.Locations

class Datasource(context: Context) {

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

    fun loadBars(): List<Locations>{
        return loadLoactions().filter { it.isBar }
    }

    fun loadClubs(): List<Locations>{
        return loadLoactions().filter { !it.isBar }
    }
}