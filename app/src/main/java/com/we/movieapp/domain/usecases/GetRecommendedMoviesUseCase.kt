package com.we.movieapp.domain.usecases

import com.we.movieapp.domain.Repository
import javax.inject.Inject

class GetRecommendedMoviesUseCase @Inject constructor(private val moviesRepository: Repository){
    fun getRecommendedMovies(movieId: Int) = moviesRepository.getRecommendationMovies(movieId)
}