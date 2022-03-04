package com.arbisoft.dogbreedsearch.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
    view.load(s)
}