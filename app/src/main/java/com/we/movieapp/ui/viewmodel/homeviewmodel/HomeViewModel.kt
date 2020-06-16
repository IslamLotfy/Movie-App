package com.we.movieapp.ui.viewmodel.homeviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.BaseViewModel
import com.we.movieapp.domain.usecases.MovieUseCase
import com.we.movieapp.domain.usecases.PersonUseCase
import com.we.movieapp.domain.usecases.TvUseCase
import com.we.movieapp.ui.utils.ViewState
import com.we.movieapp.ui.entities.MovieUiModel
import com.we.movieapp.ui.entities.PersonUiModel
import com.we.movieapp.ui.entities.TvUiModel
import com.we.movieapp.ui.mapper.MovieMapperUi
import com.we.movieapp.ui.mapper.PersonMapperUi
import com.we.movieapp.ui.mapper.TVMapperUi
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    baseSchedulerProvider: BaseSchedulerProvider,
    private val useCase: MovieUseCase,
    private val mapper: MovieMapperUi,
    private val personUseCase: PersonUseCase,
    private val personMapper: PersonMapperUi,
    private val tvUseCase: TvUseCase,
    private val tvMapper: TVMapperUi
) : BaseViewModel(baseSchedulerProvider) {

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

    fun getTopRatedMovies(pageNumber: Int): LiveData<ViewState<List<MovieUiModel>>> {

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
            useCase = useCase.getTopRatedMovies(pageNumber)//7wzd5n
        )

        return moviesLiveData
    }

    fun getPersons(pageNumber: Int): LiveData<ViewState<List<PersonUiModel>>> {
        val personsLiveData = MutableLiveData<ViewState<List<PersonUiModel>>>()

        execute(
            loadingConsumer = Consumer {
                personsLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { personItemList ->
                personItemList?.let {
                    personsLiveData.postValue(
                        ViewState.success(personMapper.mapToUiModelList(it))
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                personsLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = personUseCase.getPersons(pageNumber)//7wzd5n
        )

        return personsLiveData
    }

    fun getTvs(pageNumber: Int): LiveData<ViewState<List<TvUiModel>>> {

        val tvsLiveData = MutableLiveData<ViewState<List<TvUiModel>>>()

        execute(
            loadingConsumer = Consumer {
                tvsLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { tvItemList ->
                tvItemList?.let {
                    tvsLiveData.postValue(
                        ViewState.success(tvMapper.mapToUiModelList(it))
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                tvsLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = tvUseCase.getTvs(pageNumber)//7wzd5n
        )

        return tvsLiveData
    }

}