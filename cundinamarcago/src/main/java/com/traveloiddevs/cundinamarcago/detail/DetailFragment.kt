package com.traveloiddevs.cundinamarcago.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso
import com.traveloiddevs.cundinamarcago.R
import com.traveloiddevs.cundinamarcago.databinding.FragmentDetailBinding
import com.traveloiddevs.cundinamarcago.list.ListViewModel
import com.traveloiddevs.cundinamarcago.main.MainActivity
import com.traveloiddevs.cundinamarcago.model.TouristPlaceItem

class DetailFragment : Fragment() {
    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       (activity as MainActivity?)?.showIcon() // Drawer and tapped activity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        //detailViewModel = ViewModelProvider(this)[detailViewModel::class.java]
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val touristPlace = args.touristPlace

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        with(detailBinding) {
            nameTextView.text =  touristPlace.name
            ratingTextView.text = touristPlace.ratingStart
            weatherTextView.text = touristPlace.weather
            descriptionTextView.text = touristPlace.description
            elevationTextView.text = touristPlace.elevation
            historyTextView.text = touristPlace.history
            restaurantTextView.text =touristPlace.restaurants
            locationTextView.text = touristPlace.location
            //Para variables numericas
            //weatherTextView.text = touristPlace.weather.toString()
            Picasso.get().load(touristPlace.urlPicture).into(pictureImageView)

            mapButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(locationPlaces = touristPlace))

            }

        }
    }
    private val callback = OnMapReadyCallback { googleMap ->
        val touristPlace = args.touristPlace
        val pointPlace = LatLng(touristPlace.latitude,touristPlace.lenght)
        googleMap.addMarker(
            MarkerOptions()
            .position(pointPlace)
            .title("Ubicación "+ touristPlace.name))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pointPlace,15F))
    }

}