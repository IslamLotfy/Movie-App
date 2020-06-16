package com.we.movieapp.data.network

import com.we.movieapp.data.entities.movies.MovieRemote
import com.we.movieapp.data.entities.movies.MoviesList
import com.we.movieapp.data.entities.persons.PersonRemote
import com.we.movieapp.data.entities.tvs.TvsRemote
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
    fun getMovie(@Path("id") movieId: Int?): Single<MovieRemote>

    @GET("/3/movie/{id}/recommendations")
    fun getRecommendationMovies(@Path("id") movieId: Int?, @Query("page") pageNumber: Int = 1): Single<MoviesList>

    @GET("/3/movie/{id}/similar")
    fun getSimilarMovies(@Path("id") movieId: Int?, @Query("page")  z: Int = 1): Single<MoviesList>
    // ---------------------------------------------------------------------------------------- //

    // TV APIs
    @GET("/3/tv/popular")
    fun getTVs(@Query("page") pageNumber: Int?): Single<TvsRemote>
//
//    @GET("/3/tv/{id}")
//    fun getTV(@Path("id") tvId: Int?): Single<TVRemote>
//
//    @GET("/3/tv/{id}/recommendations")
//    fun getRecommendationTVs(@Path("id") tvId: Int?, @Query("page") pageNumber: Int = 1)
//            : Single<TVListRemote>
//
//    @GET("/3/tv/{id}/similar")
//    fun getSimilarTVs(@Path("id") tvId: Int?, @Query("page") pageNumber: Int = 1)
//            : Single<TVListRemote>
//    // ---------------------------------------------------------------------------------------- //
//
    // Person APIs
    @GET("/3/person/popular")
    fun getPersons(@Query("page") pageNumber: Int?): Single<PersonRemote>
//
//    @GET("/3/person/{id}")
//    fun getPerson(@Path("id") personId: Int?): Single<PersonRemote>
    // ---------------------------------------------------------------------------------------- //
}