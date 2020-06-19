package com.we.movieapp.domain.usecases

import com.we.movieapp.data.repository.RemoteRepository
import com.we.movieapp.domain.Repository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val moviesRepository: Repository) {
    fun getMovies(pageNumber: Int) = moviesRepository.getMovies(pageNumber)

}