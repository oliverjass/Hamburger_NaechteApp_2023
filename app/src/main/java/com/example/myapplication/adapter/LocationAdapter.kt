package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.data.model.Locations
import com.example.myapplication.databinding.LocationItemBinding
import com.example.myapplication.ui.LocationFragmentDirections
//import com.squareup.picasso.Picasso
import kotlin.math.log

class LocationAdapter(
    private var dataset: List<Locations>,
    private val context: Context,
    private val navController: NavController
) : RecyclerView.Adapter<LocationAdapter.ItemViewHolder>() {

    private val TECHNO_TYPE = 1
    private val ROCK_TYPE = 2
    private val BLACK_TYPE = 3
    private val BAR_TYPE = 4

    val stringNumber = ""
    inner class ItemViewHolder(val binding: LocationItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = LocationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        with(holder.binding) {
            tvLocationName.text = item.locationName
            tvLocationArt.text = item.locationArt
            tvLocationMusic.text = item.locationMusic

            locationCard.setOnClickListener {
                navController.navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(item.locationName.length))
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (dataset[position].locationMusic) {
            "Techno" -> TECHNO_TYPE
            "Rock" -> ROCK_TYPE
            "Black" -> BLACK_TYPE
            "Bar" -> BAR_TYPE
            else -> TECHNO_TYPE
        }
    }

    fun newData(newList: List<Locations>) {
        dataset = newList
        notifyDataSetChanged()
    }

    companion object {
        const val TECHNO_TYPE = 1
        const val ROCK_TYPE = 2
        const val BLACK_TYPE = 3
        const val BAR_TYPE = 4
    }

    override fun getItemCount(): Int {
        //Log.d("LOCATIONDATASET","$dataset")
        return dataset.size
    }



















    /*fun newData(newList: List<Locations>){
    dataset = newList
    notifyDataSetChanged()

}*/

    /*    class TechnoViewHolder(val binding: LocationItemBinding): ViewHolder(binding.root)
    class BlackViewHolder(val binding: LocationItemBinding): ViewHolder(binding.root)
    class RockViewHolder(val binding: LocationItemBinding): ViewHolder(binding.root)
    class BarViewHolder(val binding: LocationItemBinding): ViewHolder(binding.root)*/


    /*    override fun getItemViewType(position: Int): Int {
            val item = dataset[position]

            return when (item.locationMusic){
                "Techno" -> technoType
                "Rock" -> rockType
                "Black" -> blackType
                "Bar" -> barType
                else -> technoType
            }
        }*/

/*    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == technoType){
            val binding = LocationItemBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)
            TechnoViewHolder(binding)

        } else if (viewType == rockType) {
            val binding = LocationItemBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)
            RockViewHolder(binding)

        } else if (viewType == blackType) {
            val binding = LocationItemBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)
            BlackViewHolder(binding)

        } else {
        val binding = LocationItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        BarViewHolder(binding)
    }
    }*/





/*    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        with(holder.binding) {
            tvLocationName.text = item.locationName
            tvLocationArt.text = item.locationArt
            tvLocationMusic.text = item.locationMusic

            locationCard.setOnClickListener {
                navController.navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(item.locationName.length))
            }
        }
    }*/

/*    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        //Beim Haupt project eerstmal auskommentieren
        *//*
        val detailIntent = Intent(context,DetailFragment::class.java)
         *//*

        if (holder is TechnoViewHolder){
            holder.binding.tvLocationName.text = item.locationName
            holder.binding.tvLocationArt.text = item.locationArt
            holder.binding.tvLocationMusic.text = item.locationMusic

            //coil benutzen um bild zu laden
       *//*     holder.binding.imageView.load(""){

            }*//*
            holder.binding.locationCard.setOnClickListener {

                navController.navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(item.locationName.length))

                *//*detailIntent.putExtra("stringResource1",item.stringResource1)
                detailIntent.putExtra("stringResource2",item.stringResource2)
                detailIntent.putExtra("imageResource",item.imageResource)
                //Beim Haupt project eerstmal auskommentieren
                //context.startActivity(detailIntent)
                 *//*
            }
        }    else  if (holder is RockViewHolder){
            holder.binding.tvLocationName.text = item.locationName
            holder.binding.tvLocationArt.text = item.locationArt
            holder.binding.tvLocationMusic.text = item.locationMusic
            //holder.binding.imageView.setImageResource(item.imageResource.length)
            holder.binding.locationCard.setOnClickListener {

                navController.navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(item.locationName.length))

                *//*detailIntent.putExtra("stringResource1",item.stringResource1)
                detailIntent.putExtra("stringResource2",item.stringResource2)
                detailIntent.putExtra("imageResource",item.imageResource)
                //Beim Haupt project eerstmal auskommentieren
                //context.startActivity(detailIntent)
                 *//*
            }
        } else  if (holder is BlackViewHolder) {
            holder.binding.tvLocationName.text = item.locationName
            holder.binding.tvLocationArt.text = item.locationArt
            holder.binding.tvLocationMusic.text = item.locationMusic
            //holder.binding.imageView.setImageResource(item.imageResource.length)
            holder.binding.locationCard.setOnClickListener {

                navController.navigate(
                    LocationFragmentDirections.actionLocationFragmentToDetailFragment(
                        item.locationName.length
                    )
                )

*//*                detailIntent.putExtra("stringResource1",item.stringResource1)
                detailIntent.putExtra("stringResource2",item.stringResource2)
                detailIntent.putExtra("imageResource",item.imageResource)*//*
                //Beim Haupt project eerstmal auskommentieren
                //context.startActivity(detailIntent)

            }
        } else if (holder is BarViewHolder){

            holder.binding.tvLocationName.text = item.locationName
            holder.binding.tvLocationArt.text = item.locationArt

            //holder.binding.imageView.setImageResource(item.imageResource.length)
            holder.binding.locationCard.setOnClickListener {

                navController.navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(item.locationName.length))
*//*                                detailIntent.putExtra("stringResource1",item.stringResource1)
                                detailIntent.putExtra("stringResource2",item.stringResource2)
                                detailIntent.putExtra("imageResource",item.imageResource)*//*
                //context.startActivity(detailIntent)
            }
        }
    }*/

}
