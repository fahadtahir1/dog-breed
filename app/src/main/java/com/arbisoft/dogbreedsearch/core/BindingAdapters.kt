package com.arbisoft.dogbreedsearch.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.load
import com.arbisoft.dogbreedsearch.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
    view.load(s)
}