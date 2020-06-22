package com.we.movieapp.ui.view.detail

import androidx.lifecycle.ViewModel
import com.we.movieapp.ui.di.ViewModelKey
import com.we.movieapp.ui.view.detail.MovieDetailsViewModel
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