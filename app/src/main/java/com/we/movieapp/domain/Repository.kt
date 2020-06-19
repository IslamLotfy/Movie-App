package com.we.movieapp.domain

import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.domain.entities.PersonEntity
import com.we.movieapp.domain.entities.TvEntity
import io.reactivex.Flowable

interface Repository {

    fun getMovies(pageNumber: Int): Flowable<List<MovieEntity>>

    fun getPersons(pageNumber: Int): Flowable<List<PersonEntity>>

    fun getTopRatedMovies(pageNumber: Int): Flowable<List<MovieEntity>>

    fun getMovie(movieId: Int): Flowable<MovieEntity>

    fun getSimilarMovies(movieId: Int): Flowable<List<MovieEntity>>

    fun getRecommendationMovies(movieId: Int): Flowable<List<MovieEntity>>

    fun getTvs(pageNumber: Int): Flowable<List<TvEntity>>
}