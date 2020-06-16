package com.we.movieapp.ui.viewmodel.moviedetailviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.we.movieapp.domain.usecases.MovieUseCase
import com.we.movieapp.ui.entities.MovieUiModel
import com.we.movieapp.ui.mapper.MovieMapperUi
import com.we.movieapp.ui.utils.ViewState
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val useCase: MovieUseCase,
    private val mapper: MovieMapperUi,
    baseSchedulerProvider: BaseSchedulerProvider): BaseViewModel(baseSchedulerProvider) {

    fun getMovieDetails(movieId: Int): LiveData<ViewState<MovieUiModel>> {
        val moviesLiveData = MutableLiveData<ViewState<MovieUiModel>>()

        execute(
            loadingConsumer = Consumer {
                moviesLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    moviesLiveData.postValue(
                        ViewState.success(mapper.mapToUiModel(it))
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                moviesLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = useCase.getMovie(movieId)//7wzd5n
        )

        return moviesLiveData

    }

    fun getSimilarMovies(movieId: Int): LiveData<ViewState<List<MovieUiModel>>> {

        val moviesLiveData = MutableLiveData<ViewState<List<MovieUiModel>>>()

        execute(
            loadingConsumer = Consumer {
                moviesLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    moviesLiveData.postValue(
                        ViewState.success(mapper.mapToUiModelList(it))
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                moviesLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = useCase.getSimilarMovies(movieId)//7wzd5n
        )

        return moviesLiveData

    }

    fun getRecommendationMovies(movieId: Int): LiveData<ViewState<List<MovieUiModel>>> {
        val moviesLiveData = MutableLiveData<ViewState<List<MovieUiModel>>>()

        execute(
            loadingConsumer = Consumer {
                moviesLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    moviesLiveData.postValue(
                        ViewState.success(mapper.mapToUiModelList(it))
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                moviesLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = useCase.getRecommendationMovies(movieId)//7wzd5n
        )

        return moviesLiveData

    }
}