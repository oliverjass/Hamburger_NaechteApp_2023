package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ParentItemBinding
import com.example.myapplication.model.MainModel

class MainAdapter (private val collection: List<MainModel>
) : RecyclerView.Adapter<MainAdapter.CollectionViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainAdapter.CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item,parent,false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.CollectionViewHolder, position: Int) {
        holder.binding.apply {
            val collection = collection[position]
            eventGenresTV.text = collection.title
            val eventAdapter = EventAdapter(collection.eventModels)
            eventWocheRV.adapter = eventAdapter
        }
    }


    inner class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ParentItemBinding.bind(itemView)
    }

    override fun getItemCount() = collection.size

}