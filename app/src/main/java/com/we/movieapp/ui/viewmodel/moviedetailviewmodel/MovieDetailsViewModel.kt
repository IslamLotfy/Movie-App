package com.we.movieapp.ui.viewmodel.moviedetailviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.domain.usecases.GetMovieDetailUseCase
import com.we.movieapp.domain.usecases.GetRecommendedMoviesUseCase
import com.we.movieapp.domain.usecases.GetSimilarMoviesUseCase
import com.we.movieapp.ui.utils.ViewState
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase,
    private val getRecommendedMoviesUseCase: GetRecommendedMoviesUseCase,
    baseSchedulerProvider: BaseSchedulerProvider): BaseViewModel(baseSchedulerProvider) {

    fun getMovieDetails(movieId: Int): LiveData<ViewState<MovieEntity>> {
        val moviesLiveData = MutableLiveData<ViewState<MovieEntity>>()

        execute(
            loadingConsumer = Consumer {
                moviesLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    moviesLiveData.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                moviesLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = getMovieDetailsUseCase.getMovieDetail(movieId)//7wzd5n
        )

        return moviesLiveData

    }

    fun getSimilarMovies(movieId: Int): LiveData<ViewState<List<MovieEntity>>> {

        val moviesLiveData = MutableLiveData<ViewState<List<MovieEntity>>>()

        execute(
            loadingConsumer = Consumer {
                moviesLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    moviesLiveData.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                moviesLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = getSimilarMoviesUseCase.getSimilarMovies(movieId)//7wzd5n
        )

        return moviesLiveData

    }

    fun getRecommendationMovies(movieId: Int): LiveData<ViewState<List<MovieEntity>>> {
        val moviesLiveData = MutableLiveData<ViewState<List<MovieEntity>>>()

        execute(
            loadingConsumer = Consumer {
                moviesLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    moviesLiveData.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                moviesLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = getRecommendedMoviesUseCase.getRecommendedMovies(movieId)//7wzd5n
        )

        return moviesLiveData

    }
}