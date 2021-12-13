package com.traveloiddevs.cundinamarcago.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveloiddevs.cundinamarcago.databinding.FragmentListBinding
import com.traveloiddevs.cundinamarcago.main.MainActivity
import com.traveloiddevs.cundinamarcago.model.TouristPlaceItem

class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var touristPlacesAdapter: TouristPlacesAdapter
    private var touristPlacesList: ArrayList<TouristPlaceItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon() //  No se usa en Drawer ni tapped Activity
        listViewModel.loadMockTouristPlacesFromJson(context?.assets?.open("touristPlaces.json"))
        listViewModel.onTouristPlacesLoaded.observe(viewLifecycleOwner,{result ->
                onTouristPlacesLoadedSubscribe(result)
            }
        )
        touristPlacesAdapter = TouristPlacesAdapter(touristPlacesList, onItemClicked = {onTouristPlaceClicked(it)})

        listBinding.traveloidReciclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristPlacesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onTouristPlacesLoadedSubscribe(result: ArrayList<TouristPlaceItem>?) {
        result?.let{ touristPlacesList ->
            touristPlacesAdapter.appendItems(touristPlacesList)

            /* TODO Revisar Feedback (No funciono aún)
            this.touristPlacesList = touristPlacesList
            touristPlacesAdapter.notifyDataSetChanged()

             */
        }
    }

    private fun onTouristPlaceClicked(touristPlace: TouristPlaceItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(touristPlace = touristPlace))
        //findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment2())
    }

}