package com.we.movieapp.ui.di

import com.we.movieapp.ui.view.home.HomeActivity
import com.we.movieapp.ui.view.detail.MovieDetailsActivity
import com.we.movieapp.ui.view.home.HomeViewModelModule
import com.we.movieapp.ui.view.detail.MovieDetailsViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeViewModelModule::class])
    abstract fun contributeMainActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [MovieDetailsViewModelModule::class])
    abstract fun contributeMovieDetailsActivity(): MovieDetailsActivity


}