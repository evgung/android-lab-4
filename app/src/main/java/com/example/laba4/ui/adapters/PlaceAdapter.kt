package com.example.laba4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laba4.data.Place
import com.example.laba4.databinding.ItemPlaceBinding

class PlaceAdapter(
    private val places: List<Place>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemPlaceBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPlaceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]

        with (holder.binding) {
            placeName.text = place.name
            placeImage.setImageResource(place.imageResId)
            root.setOnClickListener { onItemClick(place.id) }
        }
    }

    override fun getItemCount() = places.size
}