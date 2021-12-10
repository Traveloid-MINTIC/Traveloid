package com.traveloiddevs.cundinamarcago.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.traveloiddevs.cundinamarcago.databinding.FragmentListBinding
import com.traveloiddevs.cundinamarcago.model.TouristPlace
import com.traveloiddevs.cundinamarcago.model.TouristPlaceItem

class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var touristPlacesAdapter: TouristPlacesAdapter
    private lateinit var touristPlacesList: ArrayList<TouristPlaceItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        touristPlacesList = loadMockTouristPlacesFromJson()
        touristPlacesAdapter = TouristPlacesAdapter(touristPlacesList, onItemClicked = {onTouristPlaceClicked(it)})

        listBinding.traveloidReciclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristPlacesAdapter
            setHasFixedSize(false)
        }
    }
    private fun onTouristPlaceClicked(touristPlace: TouristPlaceItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(touristPlace = touristPlace))
        //findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment2())
    }
    private fun loadMockTouristPlacesFromJson(): ArrayList<TouristPlaceItem> {
        val TouristPlacesString: String = context?.assets?.open("touristPlaces.json")?.bufferedReader().use { it!!.readText() }//TODO Reparar !!
        val gson = Gson()
        val data = gson.fromJson(TouristPlacesString, TouristPlace::class.java )
        return data
    }
}