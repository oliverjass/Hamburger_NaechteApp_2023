package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.R
import com.example.myapplication.databinding.EventItemBinding
import com.example.myapplication.data.model.EventModel

class EventAdapter (private val eventModel: List<EventModel>
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item,parent,false)
        return EventViewHolder(view)
    }


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.binding.apply {
            eventPosterIMG.load(eventModel[position].imageUrl)
        }
    }


    inner class EventViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val binding = EventItemBinding.bind(itemView)

    }


    override fun getItemCount() = eventModel.size
}




