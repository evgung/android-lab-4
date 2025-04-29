package com.example.laba4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.laba4.databinding.FragmentDetailBinding
import com.example.laba4.ui.viewmodels.PlacesViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: PlacesViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val placeId = arguments?.getInt("placeId") ?: return
        val place = viewModel.getPlaceById(placeId)

        place?.let {
            binding.placeName.text = it.name
            binding.placeDescription.text = it.description
            binding.placeAddress.text = it.address
            binding.placeImage.setImageResource(it.imageResId)
        }
    }
}