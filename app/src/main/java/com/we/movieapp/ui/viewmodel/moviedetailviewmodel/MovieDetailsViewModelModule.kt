package com.we.movieapp.ui.viewmodel.moviedetailviewmodel

import androidx.lifecycle.ViewModel
import com.we.movieapp.ui.di.ViewModelKey
import com.we.movieapp.ui.viewmodel.homeviewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MovieDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel::class)
    abstract fun bindsViewModel(viewModel: MovieDetailsViewModel): ViewModel
}