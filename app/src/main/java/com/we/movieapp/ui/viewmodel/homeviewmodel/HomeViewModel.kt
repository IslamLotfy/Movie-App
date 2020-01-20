package com.we.movieapp.ui.viewmodel.homeviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.BaseViewModel
import com.we.movieapp.domain.usecases.MovieUseCase
import com.we.movieapp.ui.utils.ViewState
import com.we.movieapp.ui.entities.MovieUiModel
import com.we.movieapp.ui.mapper.MovieMapperUi
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor(baseSchedulerProvider: BaseSchedulerProvider,
                                        private val useCase: MovieUseCase,
                                        private val mapper: MovieMapperUi
): BaseViewModel(baseSchedulerProvider) {

    fun getMovies(pageNumber: Int): LiveData<ViewState<List<MovieUiModel>>> {

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
            useCase = useCase.getMovies(pageNumber)//7wzd5n
        )

        return moviesLiveData
    }

}