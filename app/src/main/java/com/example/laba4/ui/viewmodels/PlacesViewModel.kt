package com.example.laba4.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laba4.data.Category
import com.example.laba4.data.DataSource
import com.example.laba4.data.Place

class PlacesViewModel : ViewModel() {
    private val _places = MutableLiveData<List<Place>>()
    val places: LiveData<List<Place>> = _places

    fun loadPlacesByCategory(category: Category) {
        _places.value = DataSource.getPlacesByCategory(category)
    }

    fun getPlaceById(id: Int): Place? {
        return DataSource.getPlaceById(id)
    }
}