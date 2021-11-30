package com.traveloiddevs.traveloid.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.traveloiddevs.traveloid.R
import com.traveloiddevs.traveloid.databinding.ActivityDetailBinding
import com.traveloiddevs.traveloid.model.TouristPlaceItem
import java.io.Serializable

class DetailActivity : AppCompatActivity() {
    //View Binding
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val touristPlace: TouristPlaceItem = intent.extras?.getSerializable("touristPlace") as TouristPlaceItem
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