package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.adapter.LocationAdapter
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
        // Inflate the layout for this fragment
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }


    // Viewmodel im onViewreated

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allLocations.observe(viewLifecycleOwner){
            Log.d("Datenbanktest","$it")
        }

        /*val adapter = LocationAdapter(emptyList(it))
        binding.rvLocations.adapter = adapter*/




/*        viewModel.allLocations.observe(viewLifecycleOwner){
            adapter.newData(it)
        }*/

        binding.rvLocations.hasFixedSize()

        viewModel.locations.observe(viewLifecycleOwner) { locations ->
            binding.rvLocations.adapter = LocationAdapter(
                dataset = locations,
                context = requireContext(),
                navController = findNavController()
            )


        }


        //binding.btnClubs.setOnClickListener {
        //    binding.rvLocations.adapter = LocationAdapter(AppRepository().loadClubs())
        //}



    }
}