package com.we.movieapp.domain.usecases

import com.we.movieapp.domain.Repository
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(private val moviesRepository: Repository) {
    fun getTopRatedMovies(pageNUmber: Int) = moviesRepository.getTopRatedMovies(pageNUmber)
}