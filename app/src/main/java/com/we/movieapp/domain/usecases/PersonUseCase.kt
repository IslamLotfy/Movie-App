package com.we.movieapp.domain.usecases

import com.we.movieapp.data.repository.RemoteRepository
import com.we.movieapp.domain.Repository
import javax.inject.Inject

class PersonUseCase @Inject constructor(private val repository: Repository) {

    fun getPersons(pageNumber: Int) = repository.getPersons(pageNumber)

}