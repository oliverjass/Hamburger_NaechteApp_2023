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
    lateinit var imageurl: ArrayList<String>
/*    lateinit var sliderView: SliderView*/
/*    lateinit var sliderAdapter: SliderAdapter*/
/*    lateinit var collectionAdapter: CollectionAdapter*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    /*    sliderView = findViewById(R.id.imageSlider)*/

        imageurl = ArrayList()
        imageurl = ((imageurl + R.drawable.dot) as ArrayList<String>)
        imageurl = ((imageurl + R.drawable.waagennbau) as ArrayList<String>)
        imageurl = ((imageurl + R.drawable.ubel_und_gefaehrlich) as ArrayList<String>)

        /*sliderAdapter = SliderAdapter(imageurl)*/
/*        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()*/

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, navController)

            navController.popBackStack(item.itemId, false)
            return@setOnItemSelectedListener true
        }
    }




    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun openMapsLink(view: View) {
        val gmmIntentUri = Uri.parse("https://maps.app.goo.gl/3awPvZodX9DV4gLi9")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }
}