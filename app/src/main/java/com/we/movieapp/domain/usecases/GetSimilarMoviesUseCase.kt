package com.we.movieapp.domain.usecases

import com.we.movieapp.domain.Repository
import javax.inject.Inject

class GetSimilarMoviesUseCase @Inject constructor(private val moviesRepository: Repository) {
    fun getSimilarMovies(movieId: Int) = moviesRepository.getSimilarMovies(movieId)
}