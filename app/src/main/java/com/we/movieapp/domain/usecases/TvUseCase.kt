package com.we.movieapp.domain.usecases

import com.we.movieapp.data.repository.RemoteRepository
import javax.inject.Inject

class TvUseCase @Inject constructor(private val repository: RemoteRepository) {

    fun getTvs(pageNumber: Int) = repository.getTvs(pageNumber)

}