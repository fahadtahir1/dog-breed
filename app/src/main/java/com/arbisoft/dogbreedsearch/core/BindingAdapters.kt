package com.arbisoft.dogbreedsearch.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.arbisoft.dogbreedsearch.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun String?.getImageUrl():String{
    return "https://cdn2.thedogapi.com/images/$this.jpg"
}


@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
 //   view.load(s?.getImageUrl())
    val options = RequestOptions.placeholderOf(R.mipmap.ic_launcher)
    Glide.with(view).setDefaultRequestOptions(options).load(s?.getImageUrl() ?: "").into(view)
}