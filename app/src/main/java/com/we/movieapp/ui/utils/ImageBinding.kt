package com.we.movieapp.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Picasso.get().load("https://image.tmdb.org/t/p/w200/$url").into(view)
}