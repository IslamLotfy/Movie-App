package com.we.movieapp.domain.usecases

import com.we.movieapp.domain.Repository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val moviesRepository: Repository) {
    fun getMovieDetail(movieId: Int) = moviesRepository.getMovie(movieId)
}