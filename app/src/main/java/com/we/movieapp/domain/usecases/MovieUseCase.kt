package com.we.movieapp.domain.usecases

import com.we.movieapp.data.repository.RemoteRepository
import javax.inject.Inject

class MovieUseCase
@Inject
constructor(private val repository: RemoteRepository) {

    fun getMovies(pageNumber: Int) = repository.getMovies(pageNumber)
//
//    fun getMovie(movieId: Int) = repository.getMovie(movieId)
//
//    fun getSimilarMovies(movieId: Int) = repository.getSimilarMovies(movieId)
//
//    fun getRecommendationMovies(movieId: Int) = repository.getRecommendationMovies(movieId)

}