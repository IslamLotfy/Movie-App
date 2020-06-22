package com.we.movieapp.ui

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import com.we.movieapp.ui.view.home.HomeActivity
import com.we.movieapp.ui.view.detail.MovieDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

fun HomeActivity.showMessage(message: String) {
//    Snackbar.make(coordinator_layout, message, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).show()
}

fun HomeActivity.startDetailsScreen(id: Int) {
//    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    this, imageView,
//                    getString(R.string.image_transition_name)
////                )
//    Intent(this, MovieDetailsActivity::class.java)
//        .putExtra(EXTRA_MOVIE, id)
//        .also { startActivity(it, options.toBundle()) }

    Intent(this, MovieDetailsActivity::class.java)
        .putExtra(EXTRA_MOVIE, id)
        .also { startActivity(it) }
}

const val EXTRA_MOVIE = "MOVIE_id"

fun HomeActivity.setVisibility(isLoading: Boolean, errorMessage: String? = null) {
    movie_loading.visibility = if (isLoading) View.VISIBLE else View.GONE
    movie_recycler_view_list.visibility = if (isLoading) View.GONE else View.VISIBLE
    errorMessage?.let {
        person_error.visibility = if (isLoading) View.GONE else View.VISIBLE
        person_error.text = it
    }
}

fun HomeActivity.bindViews() {
    with(movie_recycler_view_list) {
        itemAnimator = DefaultItemAnimator()
        setHasFixedSize(true)
        adapter = homeMovieAdapter
    }

    with(person_recycler_view_list){
        itemAnimator = DefaultItemAnimator()
        setHasFixedSize(true)
        adapter = personsAdapter
    }

    with(tv_recycler_view_list){
        itemAnimator = DefaultItemAnimator()
        setHasFixedSize(true)
        adapter = tvsAdapter
    }
}

fun MovieDetailsActivity.setVisibility(isLoading: Boolean, errorMessage: String? = null) {

}