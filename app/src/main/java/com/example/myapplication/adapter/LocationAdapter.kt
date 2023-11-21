package com.example.myapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.databinding.LocationItemBinding
import com.example.myapplication.ui.HomeFragmentDirections
import com.example.myapplication.R
import com.example.myapplication.data.datamodels.Locations
import com.example.myapplication.ui.MainViewModel

class LocationAdapter(
    private var dataset: List<Locations>,
    private val context: Context,
    private val navController: NavController,
    private val mainViewModel: MainViewModel
) : RecyclerView.Adapter<LocationAdapter.ItemViewHolder>() {

    private val TECHNO_TYPE = 1                                                                     // locationTypes haben einen Int wert, sodass die locations anhand des inhalts gefiltert werden können
    private val ROCK_TYPE = 2
    private val BLACK_TYPE = 3
    private val BAR_TYPE = 4



    inner class ItemViewHolder(val binding: LocationItemBinding) :                                  // Innere klasse ItemViewHolder, die eine ansicht für eine recyclerview von listen von elementen verwendet werden kann
        RecyclerView.ViewHolder(binding.root)






                                                                                                    //ViewHolder wird created für den RV
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = LocationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]                                                                // values werden erstellt
        val addBtn = holder.binding.btnAdd

        holder.binding.tvLocationName.text = item.locationName                                      // Die Listenelemente werden hier in den onBindviewHolder geladen, die im layout angegeben wurde
        holder.binding.tvLocationArt.text = item.locationArt
        holder.binding.tvLocationMusic.text = item.locationMusic
        holder.binding.imageView.load(item.imageResource)                                           // Coil image loader

        holder.binding.btnAdd.setImageResource(                                                     // Grafische anzeige für den Like Button, sobald sie gedrückt wird
            if (item.isBookmarked){
                R.drawable.btn_heart_filled
            } else {
                R.drawable.btn_heart_outline
            }
        )
        addBtn.setOnClickListener {                                                          // Dieser Code aktualisiert den Status eines Lesezeichens für ein Element wenn auf einen Button geklickt wird, und ändert gleichzeitig das Bild des Buttons entsprechend dem aktualisierten Status.
            if (item.isBookmarked) {                                                                // mithilfe von cache wird die action zwischengespeichert
                mainViewModel.cacheLocation(item.copy(isBookmarked = false))                        // Wenn das Element bereits markiert ist, ändere den Status auf "nicht markiert"
                addBtn.setImageResource(R.drawable.btn_heart_filled)                                // Ändere das Bild auf ein leeres Herz
            } else {
                mainViewModel.cacheLocation(item.copy(isBookmarked = true))                         // Wenn das Element nicht markiert ist, ändere den Status auf "markiert"
                addBtn.setImageResource(R.drawable.btn_heart_outline)                               // Ändere das Bild auf ein gefülltes Herz
            }
        }
                                                                                                    // navigieren zu Detailfragment
        holder.binding.locationCard.setOnClickListener {
            navController.navigate(
                HomeFragmentDirections.actionLocationFragmentToDetailFragment(
                    item.locationID
                )
            )
        }
    }




    override fun getItemCount(): Int {                                                              // eine Funktion gibt die Anzahl der Elemente in einem dataset zurück, der in der RecyclerView angezeigt werden soll
        Log.d("LOCATIONDATASET", "$dataset")
        return dataset.size
    }


    override fun getItemViewType(position: Int): Int {                                              // Hier ist eine When verzweigung, wenn die Location von inhalt sich unterscheiden werden sie von den TYPES zugeilt
        return when (dataset[position].locationMusic) {
            "Techno" -> TECHNO_TYPE
            "Rock" -> ROCK_TYPE
            "Black" -> BLACK_TYPE
            "Bar" -> BAR_TYPE
            else -> TECHNO_TYPE
        }
    }




    class LocationDiffUtil(): DiffUtil.ItemCallback<Locations>() {                                  // Für den FavAdapter
        override fun areItemsTheSame(oldItem: Locations, newItem: Locations): Boolean {             //Der bereitgestellte Code definiert eine Klasse namens LocationDiffUtil, die das Interface DiffUtil.ItemCallback für den Vergleich von Elementen in einer RecyclerView-Adapter verwendet. Dieses LocationDiffUtil wird in Verbindung mit einer ListAdapter verwendet, um effizientes Aktualisieren von Änderungen in der Liste zu ermöglichen.
            return oldItem.locationID == newItem.locationID
        }





                                                                                                    // Die areContentsTheSame-Methode vergleicht die Inhalte von zwei Locations-Objekten anhand verschiedener Eigenschaften.
                                                                                                    // In dieser Methode werden die einzelnen Eigenschaften der beiden Locations-Objekte verglichen, und die Methode gibt true zurück,
                                                                                                    // wenn alle Eigenschaften gleich sind, andernfalls gibt sie false zurück. Dies stellt sicher, dass die DiffUtil korrekt feststellen kann,
                                                                                                    // ob sich die Inhalte der Objekte geändert haben.

        override fun areContentsTheSame(oldItem: Locations, newItem: Locations): Boolean {
            return oldItem.locationName == newItem.locationName &&
                    oldItem.locationID == newItem.locationID &&
                    oldItem.locationMusic == newItem.locationMusic &&
                    oldItem.webLink == newItem.webLink &&
                    oldItem.email == newItem.email &&
                    oldItem.adress == newItem.adress &&
                    oldItem.phoneNr == newItem.phoneNr &&
                    oldItem.rating == newItem.rating &&
                    oldItem.price == newItem.price &&
                    oldItem.locationArt == newItem.locationArt &&
                    oldItem.openingHours == newItem.openingHours &&
                    oldItem.isBookmarked == newItem.isBookmarked &&
                    oldItem.locationDescription == newItem.locationDescription
        }
    }
}


