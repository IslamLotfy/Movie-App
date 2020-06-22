package com.we.movieapp.ui.view.home

import androidx.lifecycle.ViewModel
import com.we.movieapp.ui.di.ViewModelKey
import com.we.movieapp.ui.view.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsViewModel(viewModel: HomeViewModel): ViewModel
}