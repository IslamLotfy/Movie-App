package com.we.movieapp.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.we.movieapp.R
import com.we.movieapp.ui.EXTRA_MOVIE

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        supportActionBar?.title = intent.getStringExtra(EXTRA_MOVIE)
    }
}
