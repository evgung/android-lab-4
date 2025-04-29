package com.example.laba4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laba4.R
import com.example.laba4.data.Category
import com.example.laba4.databinding.FragmentHomeBinding
import com.example.laba4.ui.adapters.CategoryAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = binding.categoriesRecycler

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = CategoryAdapter(Category.entries) { category ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToCategoryFragment(category)
            )
        }
    }
}