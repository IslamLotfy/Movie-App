package com.we.movieapp.ui.view.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.we.movieapp.R
import com.we.movieapp.ui.bindViews
import com.we.movieapp.ui.entities.MovieUiModel
import com.we.movieapp.ui.setVisibility
import com.we.movieapp.ui.startDetailsScreen
import com.we.movieapp.ui.utils.ViewState
import com.we.movieapp.ui.view.adapter.HomeMovieAdapter
import com.we.movieapp.ui.viewmodel.homeviewmodel.HomeViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var homeMovieAdapter: HomeMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        homeMovieAdapter.onMovieClickListener = object :
            HomeMovieAdapter.OnMovieClickListener {
            override fun setOnMovieClickListener(movieId: Int) {
                startDetailsScreen(movieId.toString())
            }
        }

        configViewModel()
        getMovies()
    }

    private fun configViewModel() {
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    private fun getMovies() {
        homeViewModel.getMovies(1).observe(this,
            Observer<ViewState<List<MovieUiModel>>> { movieViewState ->
                when (movieViewState.status) {
                    ViewState.Status.LOADING -> {
                        setVisibility(isLoading = true)
                    }

                    ViewState.Status.SUCCESS -> {
                        setVisibility(isLoading = false)
                        homeMovieAdapter.submitList(movieViewState.data)
                    }

                    ViewState.Status.ERROR -> {
                        setVisibility(isLoading = false, errorMessage = movieViewState.message)
                    }
                }
            }
        )
    }

}
