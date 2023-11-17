package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.FavAdapter
import com.example.myapplication.data.datamodels.Locations
import com.example.myapplication.databinding.FragmentFavBinding

class FavFragment : Fragment() {

    private val favLayoutBinding: FragmentFavBinding by lazy { FragmentFavBinding.inflate(layoutInflater)}
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var bookmarkedLocations: LiveData<List<Locations>>
    private lateinit var favAdapter: FavAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return favLayoutBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        favAdapter = FavAdapter(viewModel, this.requireContext())

        with(favLayoutBinding) {
            rvFav.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = favAdapter
            }
        }

        viewModel.cachedLocations.observe(viewLifecycleOwner) { locations ->
            favAdapter.submitList(locations.filter { locations -> locations.isBookmarked })
        }
    }
}
