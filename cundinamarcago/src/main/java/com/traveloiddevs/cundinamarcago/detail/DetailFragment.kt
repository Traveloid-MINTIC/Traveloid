package com.traveloiddevs.cundinamarcago.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.traveloiddevs.cundinamarcago.databinding.FragmentDetailBinding
import com.traveloiddevs.cundinamarcago.main.MainActivity

class DetailFragment : Fragment() {
    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // (activity as MainActivity?)?.showIcon()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val touristPlace = args.touristPlace

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
        }
    }

}