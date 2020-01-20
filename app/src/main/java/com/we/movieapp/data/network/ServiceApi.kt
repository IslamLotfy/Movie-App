package com.we.movieapp.data.network

import com.we.movieapp.data.entities.movies.MoviesList
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    // Movie APIs
    @GET("/3/movie/popular")
    fun getMovies(@Query("page") pageNumber: Int?): Flowable<MoviesList>

}