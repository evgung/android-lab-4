package com.example.laba4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laba4.R
import com.example.laba4.data.Category
import com.example.laba4.databinding.ItemCategoryBinding
import com.example.laba4.databinding.ItemPlaceBinding

class CategoryAdapter(
    private val categories: List<Category>,
    private val onItemClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]

        with (holder.binding) {
            categoryName.text = category.displayName
            root.setOnClickListener {
                onItemClick(category)
            }
        }
    }

    override fun getItemCount() = categories.size
}