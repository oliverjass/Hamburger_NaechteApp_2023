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
    private val args: DetailFragmentArgs by navArgs()                                               // navArgs ist eine Funktion, die das Übergeben von Daten zwischen verschiedenen Fragments in einer Android-Anwendung erleichtert. Sie automatisch generiert eine Klasse, die die Argumente repräsentiert, die ich in einem Navigation Graph definiert habe.


                                                                                                    //Zur verwendung viewBinding wird sie in der UI benutzeroberfläche erstellt.Es verwendet das FragmentDetailBinding-Objekt, um auf die Ansichtselemente des Fragments zuzugreifen, und gibt dann das Wurzelelement dieser Ansicht als Ergebnis der onCreateView-Funktion zurück.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? { binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }



                                                                                                    // Eine Funktion mit den inhalt der Details des items.v

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id: Int = args.locationId                                                               //anhand wird der navArgs inbezug auf die id der location gespeichert um sicherzustellen, dass dieser ausgewählter element richtig navigiert wird


                                                                                                    //der gesamte ihnhalt von der detail mit der logik von VM  wird geladen. zudem wird er der lebenszyklus observed mit der datenbank eingefügt
        viewModel.loadDetail(id).observe(viewLifecycleOwner) { locations ->
            locations?.let {
                viewModel.insertLocation(it)                                                        //zugriff auf die datenbank vom detail während das objekt durchgeführt wird


                with(binding) {
                                                                                                    // Bild wird mit coil geladen
                    ivImgDetailPrime.load(it.imageResource) {
                        this.placeholder(Utils.createCircularProgressDrawable(requireContext()))    // bilder mit einen LadeIndikator und Platzhalter falls das bild nicht geladen ist bzw die daten nicht geladen werden können
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
                    }

                                                                                                    // Zurückbutton der zum home zurückgnavigiert wurde
                    backButton.setOnClickListener{
                        it.findNavController().navigateUp()
                    }

                                                                                                    //Text elementen werden im detail geladen
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
                Log.d("DetailFragment", "Location ist null")                               //Log.d wenn die daten nicht geladen werden können
            }
        }
    }
}