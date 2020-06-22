package com.we.movieapp.ui.view.home

import androidx.lifecycle.*
import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.domain.entities.PersonEntity
import com.we.movieapp.domain.usecases.*
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.BaseViewModel
import com.we.movieapp.ui.utils.ViewState
import com.we.movieapp.ui.entities.TvUiModel
import com.we.movieapp.ui.mapper.TVMapperUi
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    baseSchedulerProvider: BaseSchedulerProvider,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val personUseCase: GetPersonUseCase,
    private val tvUseCase: GetTvUseCase,
    private val tvMapper: TVMapperUi
) : BaseViewModel(baseSchedulerProvider), LifecycleObserver {

    val topRatedMovies = MutableLiveData<ViewState<List<MovieEntity>>>()
    val persons = MutableLiveData<ViewState<List<PersonEntity>>>()
    val tvSeries = MutableLiveData<ViewState<List<TvUiModel>>>()
    val pageNumber = 1

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun getDataLists(){
        getTopRatedMovies(pageNumber)
        getPersons(pageNumber)
        getTvs(pageNumber)
    }

    fun getTopRatedMovies(pageNumber: Int) {

        execute(
            loadingConsumer = Consumer {
                topRatedMovies.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    topRatedMovies.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                topRatedMovies.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = getTopRatedMoviesUseCase.getTopRatedMovies(pageNumber)//7wzd5n
        )
    }

    fun getPersons(pageNumber: Int){

        execute(
            loadingConsumer = Consumer {
                persons.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { personItemList ->
                personItemList?.let {
                    persons.postValue(
                        ViewState.success(it)
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                persons.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = personUseCase.getPersons(pageNumber)//7wzd5n
        )
    }

    fun getTvs(pageNumber: Int) {


        execute(
            loadingConsumer = Consumer {
                tvSeries.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { tvItemList ->
                tvItemList?.let {
                    tvSeries.postValue(
                        ViewState.success(tvMapper.mapToUiModelList(it))
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                tvSeries.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = tvUseCase.getTvs(pageNumber)//7wzd5n
        )
    }

}