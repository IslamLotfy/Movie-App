package com.we.movieapp.ui.di

import com.we.movieapp.ui.view.activity.HomeActivity
import com.we.movieapp.ui.view.activity.MovieDetailsActivity
import com.we.movieapp.ui.viewmodel.homeviewmodel.HomeViewModelModule
import com.we.movieapp.ui.viewmodel.moviedetailviewmodel.MovieDetailsViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeViewModelModule::class])
    abstract fun contributeMainActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [MovieDetailsViewModelModule::class])
    abstract fun contributeMovieDetailsActivity(): MovieDetailsActivity


}