package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
/*import com.example.myapplication.adapter.CollectionAdapter*/
/*import com.example.myapplication.adapter.SliderAdapter*/
import com.example.myapplication.data.AppRepository
import com.example.myapplication.databinding.ActivityMainBinding
import com.smarteist.autoimageslider.SliderView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var appRepository: AppRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        binding = ActivityMainBinding.inflate(layoutInflater)                                       // viewbinding in die Activity initialisieren. binding-objekt wird erszellt um den zugriff auf das layout UI zu erleichtern
        setContentView(binding.root)



        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

                                                                                                    //Hier wird ein Listener für die Auswahl von Elementen in der bottomNavigationView (untere Navigationsleiste) festgelegt.
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, navController)
                                                                                                    // Dieser Teil des Codes verbindet das ausgewählte Element (item) mit dem navController. Das bedeutet, dass das ausgewählte Element für die Navigation verwendet wird.
            navController.popBackStack(item.itemId, false)
            return@setOnItemSelectedListener true                                                   //Der Listener gibt true zurück, um anzuzeigen, dass die Aktion des ausgewählten Elements behandelt wurde.

                                                                                                    //Dieser Code verwendet das Navigation Component Framework in Android. Er verbindet die Navigation zwischen Fragmenten (Bildschirmen) mit der Auswahl von Elementen in der unteren Navigationsleiste (bottomNavigationView). Bei Auswahl eines Elements wird die Navigation durchgeführt, und der Rückwärts-Stack wird entsprechend aktualisiert
        }
    }




    override fun onSupportNavigateUp(): Boolean {                                                   // Navigation
        return navController.navigateUp() || super.onSupportNavigateUp()
    }



    fun openMapsLink(view: View) {                                                                  // funktion zu einer link in googlemaps, mit der aktion der klick innerhalb der detail wenn man auf die Adresse klickt. sie ist jedoch ausgeschaltet
        val gmmIntentUri = Uri.parse("https://maps.app.goo.gl/3awPvZodX9DV4gLi9")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }
}