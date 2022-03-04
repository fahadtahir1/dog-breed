package com.arbisoft.dogbreedsearch.utils.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T : Any, VB : ViewDataBinding> :
    RecyclerView.Adapter<BaseRecyclerAdapter.Companion.BaseViewHolder<VB>>() {

    var listener: ((view: VB, item: T, position: Int) -> Unit)? = null

    var items = mutableListOf<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    companion object {
        class BaseViewHolder<VB : ViewDataBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder<VB>(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )
    )

    override fun getItemCount() = items.size

    abstract val layout: Int
}