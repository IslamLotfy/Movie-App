package com.we.movieapp.ui.view.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.we.movieapp.R
import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.domain.entities.PersonEntity
import com.we.movieapp.ui.bindViews
import com.we.movieapp.ui.entities.TvUiModel
import com.we.movieapp.ui.setVisibility
import com.we.movieapp.ui.startDetailsScreen
import com.we.movieapp.ui.utils.ViewState
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var homeMovieAdapter: HomeMovieAdapter

    @Inject
    lateinit var personsAdapter: PersonsAdapter

    @Inject
    lateinit var tvsAdapter: TvsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        homeMovieAdapter.onMovieClickListener = object :
            HomeMovieAdapter.OnMovieClickListener {
            override fun setOnMovieClickListener(movieId: Int) {
                startDetailsScreen(movieId)
            }
        }

        personsAdapter.onOnPersonClickListener = object :
            PersonsAdapter.OnPersonClickListener {
            override fun setOnPersonClickListener(movieId: Int) {
                startDetailsScreen(movieId)
            }
        }

        tvsAdapter.onTvClickListener = object :
            TvsAdapter.OnTvClickListener {
            override fun setOnTvClickListener(movieId: Int) {
                startDetailsScreen(movieId)
            }
        }

        configViewModel()

        observeOnMovies()
        observeOnTVSeries()
        observeOnPersons()
    }

    private fun configViewModel() {
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        lifecycle.addObserver(homeViewModel)
    }

    private fun observeOnMovies() {
        homeViewModel.topRatedMovies.observe(this,
            Observer { movieViewState ->
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

    private fun observeOnTVSeries() {
        homeViewModel.tvSeries.observe(this,
            Observer { tvViewState ->
                when (tvViewState.status) {
                    ViewState.Status.LOADING -> {
                        setVisibility(isLoading = true)
                    }

                    ViewState.Status.SUCCESS -> {
                        setVisibility(isLoading = false)
                        tvsAdapter.submitList(tvViewState.data)
                    }

                    ViewState.Status.ERROR -> {
                        setVisibility(isLoading = false, errorMessage = tvViewState.message)
                    }
                }
            }
        )
    }

    private fun observeOnPersons(){
        homeViewModel.persons.observe(this,
            Observer { personViewState ->
                when (personViewState.status) {
                    ViewState.Status.LOADING -> {
                        setVisibility(isLoading = true)
                    }

                    ViewState.Status.SUCCESS -> {
                        setVisibility(isLoading = false)
                        personsAdapter.submitList(personViewState.data)
                    }

                    ViewState.Status.ERROR -> {
                        setVisibility(isLoading = false, errorMessage = personViewState.message)
                    }
                }
            }
        )
    }


}
