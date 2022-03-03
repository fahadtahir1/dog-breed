package com.arbisoft.dogbreedsearch.presentation.breeds

import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.core.base.BaseRecyclerAdapter
import com.arbisoft.dogbreedsearch.databinding.ItemMainDogBinding
import com.arbisoft.dogbreedsearch.domain.model.Breed
import com.arbisoft.dogbreedsearch.domain.model.BreedDetails

class BreedAdapter : BaseRecyclerAdapter<BreedDetails, ItemMainDogBinding>() {
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