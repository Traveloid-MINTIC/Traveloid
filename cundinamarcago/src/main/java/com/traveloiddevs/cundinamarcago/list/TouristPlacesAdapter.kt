package com.traveloiddevs.cundinamarcago.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.traveloiddevs.cundinamarcago.R
import com.traveloiddevs.cundinamarcago.model.TouristPlaceItem

class TouristPlacesAdapter(
    /*Para seleccionar algo de manera sostenida
    private val onItemLongClicked: (TouristPlaceItem)-> Unit,*/
    private val touristPlacesList : ArrayList <TouristPlaceItem>,
    private val onItemClicked:(TouristPlaceItem)-> Unit

    ) : RecyclerView.Adapter <TouristPlacesAdapter.ViewHolder>() {

    //Definir el Layoot
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_traveloid_item, parent, false)
        return ViewHolder(view)
    }
    //Trae los datos de la vista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val touristPlace = touristPlacesList [position]
        //Busca la posicón del sistio turistico a elegir
        holder.itemView.setOnClickListener {onItemClicked(touristPlacesList[position])}
        /*holder.itemView.setOnLongClickListener { onItemLongClicked(touristPlacesList[position]) true}*/

        holder.bind(touristPlace)

    }
    //Cuenta los datos de la lista
    override fun getItemCount(): Int = touristPlacesList.size

    //Desarrolla cada view Holder
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var cardTextView: TextView = itemView.findViewById(R.id.card_text_view)
        private var ratingTextView: TextView = itemView.findViewById(R.id.rating_text_view)
        //private var starImageView: ImageView = itemView.findViewById(R.id.star_image_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
        fun bind (touristPlace: TouristPlaceItem){
            nameTextView.text = touristPlace.name
            cardTextView.text = touristPlace.descriptionCard
            ratingTextView.text =touristPlace.ratingStart
            Picasso.get().load(touristPlace.urlPicture).into(pictureImageView);
            //Picture            //StartImage

        }
    }
}