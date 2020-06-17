package com.we.movieapp.data.network

import com.we.movieapp.data.entities.movies.MovieRemote
import com.we.movieapp.data.entities.movies.MoviesList
import com.we.movieapp.data.entities.persons.PersonRemote
import com.we.movieapp.data.entities.tvs.TvsRemote
import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.domain.entities.PersonEntity
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    // Movie APIs
    @GET("/3/movie/popular")
    fun getMovies(@Query("page") pageNumber: Int?): Flowable<MoviesList>

    @GET("/3/movie/top_rated")
    fun getTopRatedMovies(@Query("page") pageNumber: Int?): Flowable<MoviesList>

    @GET("/3/movie/{id}")
    fun getMovie(@Path("id") movieId: Int?): Flowable<MovieRemote>

    @GET("/3/movie/{id}/recommendations")
    fun getRecommendationMovies(@Path("id") movieId: Int?, @Query("page") pageNumber: Int = 1): Flowable<MoviesList>

    @GET("/3/movie/{id}/similar")
    fun getSimilarMovies(@Path("id") movieId: Int?, @Query("page")  z: Int = 1): Flowable<MoviesList>
    // ---------------------------------------------------------------------------------------- //

    // TV APIs
    @GET("/3/tv/popular")
    fun getTVs(@Query("page") pageNumber: Int?): Flowable<TvsRemote>

    // Person APIs
    @GET("/3/person/popular")
    fun getPersons(@Query("page") pageNumber: Int?): Flowable<PersonRemote>
}