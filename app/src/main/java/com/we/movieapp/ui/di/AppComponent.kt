package com.we.movieapp.ui.di


import android.app.Application
import com.we.movieapp.ui.app.Movie
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ViewModelFactory::class,
            ActivityBuildersModule::class,
            AppModule::class
            ]
)
interface AppComponent : AndroidInjector<Movie> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}