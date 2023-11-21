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


                                                                                                    // Innereklasse von ItemViewholder wurde erstellt
    inner class ItemViewHolder(private val itemLayoutBinding: FavItemBinding): RecyclerView.ViewHolder(itemLayoutBinding.root) {

                                                                                                    // eine funktion, dass item mit bild und text geladen wird


        fun connect(item: Locations) {
            with (itemLayoutBinding) {
                imageView.load(item.imageResource) {
                    this.error(R.drawable.ic_no_image)
                    this.placeholder(Utils.createCircularProgressDrawable(context))
                    this.crossfade(true)
                    this.crossfade(1000)
                }

                tvTitle.setText(item.locationName)

                                                                                                    //der imagebutton ist bereits auf true und wird in der adapter aufgebaut und in dem fragment angezeigt. sobald man auf den delete butoon klickt wird das ausgewählte element destroyd

                favoriteImageButton.setOnClickListener {
                    viewModel.cacheLocation(item.copy(isBookmarked = false))
                }

                                                                                                    // Item ist clickable aber führt nicht zum detail

                favCardView.setOnClickListener {
                    viewModel.getLocation(item.locationID)
                }
            }
        }
    }



                                                                                                    // in der createViewholder wird itemviewholder für das layout angebunden
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(FavItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {                          //Ansichtselement des ViewHolders mit den Daten aus der Liste aktualisiert. Der Log-Eintrag dient dazu, den Inhalt des Elements für Debugging-Zwecke anzuzeigen.
        Log.d("FAVFRAGMENTtest","${currentList[position]}")
        holder.connect(currentList[position])
    }

}