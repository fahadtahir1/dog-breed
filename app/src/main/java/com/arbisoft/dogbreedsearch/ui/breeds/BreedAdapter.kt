package com.arbisoft.dogbreedsearch.ui.breeds

import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.utils.base.BaseRecyclerAdapter
import com.arbisoft.dogbreedsearch.databinding.ItemMainDogBinding

class BreedAdapter : BaseRecyclerAdapter<String, ItemMainDogBinding>() {
    override val layout: Int = R.layout.item_main_dog

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ItemMainDogBinding>,
        position: Int
    ) {
        holder.binding.data = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(holder.binding, items[position], position)
        }
    }
}