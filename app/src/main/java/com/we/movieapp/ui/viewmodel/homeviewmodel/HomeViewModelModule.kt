package com.we.movieapp.ui.viewmodel.homeviewmodel

import androidx.lifecycle.ViewModel
import com.we.movieapp.ui.di.ViewModelKey
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