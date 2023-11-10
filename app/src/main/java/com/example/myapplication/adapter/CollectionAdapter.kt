package com.example.myapplication.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.CollectionItemBinding

/*
class CollectionAdapter(private val collections: List<Collection>) :
    RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>(), Parcelable {

    class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CollectionItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.collection_item, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.binding.apply {
            val collection = collections[position]
            tvCollectionTitle.text = collection.title
            val locationAdapter = LocationAdapter(collection.location)
            recyclerViewLocations.adapter = locationAdapter
        }
    }

    override fun getItemCount() = collections.size
    }
*/

