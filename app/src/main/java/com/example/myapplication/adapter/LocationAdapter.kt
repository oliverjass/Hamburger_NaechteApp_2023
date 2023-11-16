package com.example.myapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.databinding.LocationItemBinding
import com.example.myapplication.ui.HomeFragmentDirections
import com.example.myapplication.R
import com.example.myapplication.data.datamodels.Locations
import com.example.myapplication.ui.MainViewModel

class LocationAdapter(
    private var dataset: List<Locations>,
    private val context: Context,
    private val navController: NavController,
    private val mainViewModel: MainViewModel
) : RecyclerView.Adapter<LocationAdapter.ItemViewHolder>() {

    private val TECHNO_TYPE = 1
    private val ROCK_TYPE = 2
    private val BLACK_TYPE = 3
    private val BAR_TYPE = 4



    inner class ItemViewHolder(val binding: LocationItemBinding) :
        RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            LocationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val addBtn = holder.binding.btnAdd


        holder.binding.tvLocationName.text = item.locationName
        holder.binding.tvLocationArt.text = item.locationArt
        holder.binding.tvLocationMusic.text = item.locationMusic
        /*holder.binding.imageView.load(item.imageResource)*/

        holder.binding.imageView.load("https://szene-hamburg.com/wp-content/uploads/2023/04/244414733_10158695928653163_7142350765114644475_n-1440x869.jpg")


        //setBtnBookmarkImage(holder.binding.btnAdd, item.isBookmarked)

/*        holder.binding.btnAdd.setOnClickListener {
            item.isBookmarked = !item.isBookmarked
            mainViewModel.toggleFavorite(item.locationID)
            setBtnBookmarkImage(holder.binding.btnAdd, item.isBookmarked)
        }*/

        holder.binding.btnAdd.setImageResource(
            if (item.isBookmarked){
                R.drawable.btn_heart_filled
            } else {
                R.drawable.btn_heart_outline
            }
        )

        addBtn.setOnClickListener {
            if (item.isBookmarked) {
                mainViewModel.cacheLocation(item.copy(isBookmarked = false))
                addBtn.setImageResource(R.drawable.btn_heart_filled)
            } else {
                mainViewModel.cacheLocations(item.copy(isBookmarked = true))
                addBtn.setImageResource(R.drawable.btn_heart_outline)
            }
        }

        holder.binding.locationCard.setOnClickListener {
            navController.navigate(
                HomeFragmentDirections.actionLocationFragmentToDetailFragment(
                    item.locationID

                )
            )
        }
    }

    override fun getItemCount(): Int {
        Log.d("LOCATIONDATASET", "$dataset")
        return dataset.size
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



/*    private fun setBtnBookmarkImage(imgBtn: ImageButton, isBookmarked: Boolean){
        if (isBookmarked){
            imgBtn.setImageResource(R.drawable.btn_heart_filled)
        } else {
            imgBtn.setImageResource(R.drawable.btn_heart_outline)
        }
    }*/


class LocationDiffUtil(): DiffUtil.ItemCallback<Locations>() {
        override fun areItemsTheSame(oldItem: Locations, newItem: Locations): Boolean {
            return oldItem.locationID == newItem.locationID
        }

        override fun areContentsTheSame(oldItem: Locations, newItem: Locations): Boolean {
            return oldItem.locationName == newItem.locationName &&
                    oldItem.locationID == newItem.locationID &&
                    oldItem.locationMusic == newItem.locationMusic &&
                    oldItem.webLink == newItem.webLink &&
                    oldItem.email == newItem.email &&
                    oldItem.adress == newItem.adress &&
                    oldItem.phoneNr == newItem.phoneNr &&
                    oldItem.rating == newItem.rating &&
                    oldItem.price == newItem.price &&
                    oldItem.locationArt == newItem.locationArt &&
                    oldItem.openingHours == newItem.openingHours &&
                    oldItem.isBookmarked == newItem.isBookmarked &&
                    oldItem.locationDescription == newItem.locationDescription
        }
}
}


