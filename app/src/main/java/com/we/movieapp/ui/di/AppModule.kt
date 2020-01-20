package com.we.movieapp.ui.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.we.movieapp.*
import com.we.movieapp.data.network.ApiKeyInterceptor
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.data.repository.RemoteRepository
import com.we.movieapp.data.network.ServiceApi
import com.we.movieapp.domain.mapper.MovieMapper
import com.we.movieapp.domain.usecases.MovieUseCase
import com.we.movieapp.ui.view.adapter.HomeMovieAdapter
import com.we.movieapp.ui.viewmodel.SchedulerProvider
import com.we.movieapp.ui.mapper.MovieMapperUi
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient, gson: Gson, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.themoviedb.org/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getGson(): Gson {
        return GsonBuilder().create()
    }


    @Provides
    @Singleton
    fun getHomeMovieAdapter() =
        HomeMovieAdapter()


    @Provides
    @Singleton
    fun getMovieMapper() = MovieMapper()

    @Provides
    @Singleton
    fun getMovieMapperUi() = MovieMapperUi()


//    @Provides
//    @Singleton
//    fun getInterceptor(): HttpLoggingInterceptor {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        return interceptor
//    }

    @Provides
    @Singleton
    fun getCache(file: File): Cache {
        return Cache(file, (10 * 1000 * 1000).toLong())  // 10 MiB cache
    }

    @Provides
    @Singleton
    fun getFile(application: Application): File {
        val file = File(application.filesDir, "cache_dir")
        if (!file.exists())
            file.mkdirs()
        return file
    }

    @Provides
    @Singleton
    internal fun provideApiKeyInterceptor() =
        ApiKeyInterceptor()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        return logging
    }

    @Singleton
    @Provides
    fun getAuthorizedOkHttpClient(
        cache: Cache,
        interceptor: ApiKeyInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS) // write timeout
            .readTimeout(30, TimeUnit.SECONDS) // read timeout
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthorizedServiceApi(retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }


    @Singleton
    @Provides
    fun providesTaskBaseScheduler(): BaseSchedulerProvider =
        SchedulerProvider()

    //
    @Singleton
    @Provides
    fun providesMoviesRepository(service: ServiceApi, mapper: MovieMapper) =
        RemoteRepository(service, mapper)

    @Singleton
    @Provides
    fun providesMovieUseCase(repository: RemoteRepository) = MovieUseCase(repository)

}
