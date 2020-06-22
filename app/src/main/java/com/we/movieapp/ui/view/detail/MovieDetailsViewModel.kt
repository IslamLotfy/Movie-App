package com.we.movieapp.ui.view.detail

import android.view.View
import androidx.lifecycle.*
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
    baseSchedulerProvider: BaseSchedulerProvider): BaseViewModel(baseSchedulerProvider), LifecycleObserver {

    val movieDetail = MutableLiveData<ViewState<MovieEntity>>()
    val similarMovies = MutableLiveData<ViewState<List<MovieEntity>>>()
    val recommendedMovies = MutableLiveData<ViewState<List<MovieEntity>>>()
    var movieId: Int = 38700

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun getData(){
        getMovieDetails(movieId)
        getSimilarMovies(movieId)
        getRecommendedMovies(movieId)
    }

    fun getMovieDetails(movieId: Int) {
        execute(
            loadingConsumer = Consumer {
                movieDetail.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    movieDetail.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                movieDetail.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = getMovieDetailsUseCase.getMovieDetail(movieId)//7wzd5n
        )
    }

    fun getSimilarMovies(movieId: Int){
        execute(
            loadingConsumer = Consumer {
                similarMovies.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    similarMovies.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                similarMovies.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = getSimilarMoviesUseCase.getSimilarMovies(movieId)//7wzd5n
        )
    }

    fun getRecommendedMovies(movieId: Int) {
        execute(
            loadingConsumer = Consumer {
                recommendedMovies.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    recommendedMovies.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                recommendedMovies.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = getRecommendedMoviesUseCase.getRecommendedMovies(movieId)//7wzd5n
        )
    }
}