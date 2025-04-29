package com.example.laba4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba4.databinding.FragmentCategoryBinding
import com.example.laba4.ui.adapters.PlaceAdapter
import com.example.laba4.ui.viewmodels.PlacesViewModel

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: PlacesViewModel by activityViewModels()
    private val args: CategoryFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = args.category
        viewModel.loadPlacesByCategory(category)

        binding.placesRecycler.layoutManager = LinearLayoutManager(requireContext())
        viewModel.places.observe(viewLifecycleOwner) { places ->
            binding.placesRecycler.adapter = PlaceAdapter(places) { placeId ->
                findNavController().navigate(
                    CategoryFragmentDirections.actionCategoryFragmentToDetailFragment(placeId)
                )
            }
        }
    }
}