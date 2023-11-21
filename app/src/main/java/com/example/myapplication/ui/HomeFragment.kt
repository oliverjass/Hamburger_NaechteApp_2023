package com.example.myapplication.ui

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.LocationAdapter
import com.example.myapplication.data.datamodels.Locations
/*import com.example.myapplication.adapter.SliderAdapter*/
import com.example.myapplication.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val locationId: Int = 1


                                                                                                    //das Layout wird hierbeigerufen und binding eingesetzt
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }



                                                                                                    // Filter der Itemelementen mit der verknüpfung der daten von setupRecyclerview. wenn das eingegebene element den gleichen vorrausgegebenden wert gibt, wird er aufgeteilt
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cachedLocations.observe(viewLifecycleOwner) { location ->
            setupRecyclerView(binding.rvTechno, location.filter { it.locationMusic == "Techno" })
            setupRecyclerView(binding.rvRock, location.filter { it.locationMusic == "Rock" })
            setupRecyclerView(binding.rvBlack, location.filter { it.locationMusic == "Black" })
            setupRecyclerView(binding.rvBar, location.filter { it.locationArt == "Bar" })
        }
    }


                                                                                                    // Hier werden die inhalte des locations mit logik und navigationsfunktionen allgemein herbeigerufen und in der onviewcreated den filter funktionarbarer zu machen.
    private fun setupRecyclerView(recyclerView: RecyclerView, dataset: List<Locations>) {
        recyclerView.adapter = LocationAdapter(
            dataset = dataset,
            context = requireContext(),
            navController = findNavController(),
            mainViewModel = viewModel
        )
    }

}