package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.LocationAdapter
import com.example.myapplication.data.model.Locations
import com.example.myapplication.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentLocationBinding
    private val locationId: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allLocations.observe(viewLifecycleOwner) { locations ->
            setupRecyclerView(binding.rvLocations, locations.filter { it.locationMusic == "Techno" })
            setupRecyclerView(binding.rvLocations1, locations.filter { it.locationMusic == "Rock" })
            setupRecyclerView(binding.rvLocations2, locations.filter { it.locationMusic == "Black" })
            setupRecyclerView(binding.rvLocations3, locations.filter { it.locationArt == "Bar" })
        }
    }
    private fun setupRecyclerView(recyclerView: RecyclerView, dataset: List<Locations>) {
        recyclerView.adapter = LocationAdapter(
            dataset = dataset,
            context = requireContext(),
            navController = findNavController()
        )
    }






/*    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentLocationBinding
    private val locationId: Int = 1



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }


    // Viewmodel im onViewreated

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.allLocations.observe(viewLifecycleOwner) { locations ->

            val locationTechno = locations.filter {
                it.locationMusic == "Techno"
            }

            val locationBlack = locations.filter {
                it.locationMusic == "Black"
            }

            val locationBar = locations.filter {
                it.locationArt == "Bar"
            }

            val locationRock = locations.filter {
                it.locationMusic == "Rock"
            }


            binding.rvLocations.adapter = LocationAdapter(
                dataset = locationTechno,
                context = requireContext(),
                navController = findNavController()
            )

            binding.rvLocations1.adapter = LocationAdapter(
                dataset = locationRock,
                context = requireContext(),
                navController = findNavController()
            )

            binding.rvLocations2.adapter = LocationAdapter(
                dataset = locationBlack,
                context = requireContext(),
                navController = findNavController()
            )

            binding.rvLocations3.adapter = LocationAdapter(
                dataset = locationBar,
                context = requireContext(),
                navController = findNavController()
            )


        }


        //binding.btnClubs.setOnClickListener {
        //    binding.rvLocations.adapter = LocationAdapter(AppRepository().loadClubs())
        //}



    }*/
}