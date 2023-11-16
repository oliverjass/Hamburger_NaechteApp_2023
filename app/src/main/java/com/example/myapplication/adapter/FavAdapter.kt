package com.example.myapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.R
import com.example.myapplication.data.datamodels.Locations
import com.example.myapplication.databinding.FavItemBinding
import com.example.myapplication.ui.MainViewModel
import com.example.myapplication.utils.Utils

class FavAdapter(
    private val viewModel: MainViewModel,
    private val context: Context,
): ListAdapter<Locations, FavAdapter.ItemViewHolder>(LocationAdapter.LocationDiffUtil()) {
    inner class ItemViewHolder(private val itemLayoutBinding: FavItemBinding): RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun connect(item: Locations) {
            with (itemLayoutBinding) {
/*                imageView.load(item.imageResource) {
                    this.error(R.drawable.ic_no_image)
                    this.placeholder(Utils.createCircularProgressDrawable(context))
                    this.crossfade(true)
                    this.crossfade(1000)
                }*/
                imageView.load("https://szene-hamburg.com/wp-content/uploads/2023/04/244414733_10158695928653163_7142350765114644475_n-1440x869.jpg") {
                    this.error(R.drawable.ic_no_image)
                    this.placeholder(Utils.createCircularProgressDrawable(context))
                    this.crossfade(true)
                    this.crossfade(1000)
                }

                tvTitle.setText(item.locationName)

                favoriteImageButton.setOnClickListener {
                    viewModel.cacheLocations(item.copy(isBookmarked = false))
                }

                favCardView.setOnClickListener {
                    viewModel.getLocation(item.locationID)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(FavItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Log.d("FAVFRAGMENTtest","${currentList[position]}")
        holder.connect(currentList[position])

    }

}