package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.data.model.Locations
import com.example.myapplication.databinding.BarItemBinding
import com.example.myapplication.databinding.ClubItemBinding
import com.example.myapplication.ui.LocationFragmentDirections

class LocationAdapter(
    private val dataset: List<Locations>,
    private val context: Context,
    private val navController: NavController
): RecyclerView.Adapter<ViewHolder>() {

    private val clubType = 1
    private val barType = 2

    class ClubViewHolder(val binding: ClubItemBinding): ViewHolder(binding.root)
    class BarViewHolder(val binding: BarItemBinding): ViewHolder(binding.root)


    override fun getItemViewType(position: Int): Int {
        if (dataset[position].isBar){
            return barType
        }
        return clubType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == clubType){
            val binding = ClubItemBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)
            ClubViewHolder(binding)
        } else {
            val binding = BarItemBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)
            BarViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]

        //Beim Haupt project eerstmal auskommentieren
        /*
        val detailIntent = Intent(context,DetailFragment::class.java)
         */


        if (holder is ClubViewHolder){
            holder.binding.tvClubName.text = context.getString(item.stringResource1)
            holder.binding.tvLocationArt.text = context.getString(item.stringResource2)
            holder.binding.imageView.setImageResource(item.imageResource)
            holder.binding.clubCard.setOnClickListener {

                navController.navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(item.stringResource1))

                /*detailIntent.putExtra("stringResource1",item.stringResource1)
                detailIntent.putExtra("stringResource2",item.stringResource2)
                detailIntent.putExtra("imageResource",item.imageResource)
                //Beim Haupt project eerstmal auskommentieren
                //context.startActivity(detailIntent)
                 */
            }
        } else if (holder is BarViewHolder){

            holder.binding.tvBarName.text = context.getString(item.stringResource1)
            holder.binding.tvLocationArt.text = context.getString(item.stringResource2)
            holder.binding.imageView.setImageResource(item.imageResource)
            holder.binding.barCard.setOnClickListener {

                navController.navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(item.stringResource1))
                /*
                detailIntent.putExtra("stringResource1",item.stringResource1)
                detailIntent.putExtra("stringResource2",item.stringResource2)
                detailIntent.putExtra("imageResource",item.imageResource)
                //context.startActivity(detailIntent)
                */
            }
        }
    }

}
