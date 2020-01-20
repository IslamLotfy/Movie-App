package com.we.movieapp.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Picasso.get().load("https://image.tmdb.org/t/p/w200/$url").into(view)

//    Picasso.get()
//                .load("https://image.tmdb.org/t/p/w200/$url")
////                .transform(CropSquareTransformation(10, 0))
//                .into(view, object : Callback {
//                    override fun onSuccess() {
//                        item.image_progress.hide()
//                    }
//
//                    override fun onError(e: Exception?) {
//                        item.image_progress.hide()
//                    }
//
//                }
//                )
}