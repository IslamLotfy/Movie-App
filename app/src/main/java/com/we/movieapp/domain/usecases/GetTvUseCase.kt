package com.we.movieapp.domain.usecases

import com.we.movieapp.domain.Repository
import javax.inject.Inject

class GetTvUseCase @Inject constructor(private val repository: Repository) {

    fun getTvs(pageNumber: Int) = repository.getTvs(pageNumber)

}