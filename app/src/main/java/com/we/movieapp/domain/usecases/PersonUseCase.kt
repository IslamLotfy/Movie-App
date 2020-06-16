package com.we.movieapp.domain.usecases

import com.we.movieapp.data.repository.RemoteRepository
import javax.inject.Inject

class PersonUseCase @Inject constructor(private val repository: RemoteRepository) {

    fun getPersons(pageNumber: Int) = repository.getPersons(pageNumber)

}