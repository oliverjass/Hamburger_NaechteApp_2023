/*
package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.LocationItemBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(val imageurl: ArrayList<String>):
    SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    var sliderImage:ArrayList<String> =imageurl


    override fun getCount(): Int {
        return sliderImage.size
    }



    override fun onCreateViewHolder(parent: ViewGroup): SliderViewHolder {
        var inflater: View = LayoutInflater.from(parent!!.context).inflate(R.layout.slideitem,null)
        return SliderViewHolder(inflater)

    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        if (viewHolder !=null)
            Glide.with(viewHolder.itemView).load(sliderImage.get(position)).fitCenter().into(viewHolder.imageView)

    }

    class SliderViewHolder(itemView: View): SliderViewAdapter.ViewHolder(itemView) {

        var imageView: ImageView = itemView.findViewById(R.id.myimage)

    }
}
*/
