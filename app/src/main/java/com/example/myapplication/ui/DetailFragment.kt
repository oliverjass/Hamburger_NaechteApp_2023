package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.data.datamodels.Locations
import com.example.myapplication.utils.Utils
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val args: DetailFragmentArgs by navArgs()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? { binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val locationId: Int = args.locationId

        viewModel.loadLocationDetailsVM(locationId).observe(viewLifecycleOwner) { locations ->
            locations?.let {
                viewModel.insertLocation(it)

                with(binding) {

/*                    ivImgDetailPrime.load(it.imageResource) {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }
                    imgGallery1.load(it.locationImg1) {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }
                    imgGallery2.load(it.locationImg2) {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }
                    imgGallery3.load(it.locationImg3) {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }*/

                    ivImgDetailPrime.load("https://szene-hamburg.com/wp-content/uploads/2023/04/244414733_10158695928653163_7142350765114644475_n-1440x869.jpg") {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }
                    imgGallery1.load("https://szene-hamburg.com/wp-content/uploads/2023/04/244414733_10158695928653163_7142350765114644475_n-1440x869.jpg") {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }
                    imgGallery2.load("https://szene-hamburg.com/wp-content/uploads/2023/04/244414733_10158695928653163_7142350765114644475_n-1440x869.jpg") {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }
                    imgGallery3.load("https://szene-hamburg.com/wp-content/uploads/2023/04/244414733_10158695928653163_7142350765114644475_n-1440x869.jpg") {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))
                        this.error(R.drawable.ic_no_image)
                        this.crossfade(true)
                        this.crossfade(2000)
                    }
                    backButton.setOnClickListener{
                        it.findNavController().navigateUp()
                    }
                    tvDaytime.text = it.openingHours
                    tvAdress.text = it.adress
                    tvWebLink.text = it.webLink
                    tvEmail.text = it.email
                    tvKurzbeschreibung.text = it.locationDescription
                    tvEintritt.text = it.price
                    tvLocationDetail.text = it.locationName
                    tvLocationArtDetail.text = it.locationArt
                    tvRating.text = it.rating
                    tvMusic.text = it.locationMusic
                    tvPhoneNr.text = it.phoneNr
                }
            } ?: run {
                Log.d("DetailFragment", "Location ist null")
            }
        }
    }
}