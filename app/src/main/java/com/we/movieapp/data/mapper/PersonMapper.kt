package com.we.movieapp.data.mapper

import com.we.movieapp.data.entities.persons.RemoteResult
import com.we.movieapp.domain.entities.PersonEntity

class PersonMapper : MapFromRemoteToEntity<RemoteResult, PersonEntity> {
    override fun mapFromRemoteToEntity(model: RemoteResult): PersonEntity {
        with(model) {
            return PersonEntity(
                id = id,
                profilePath = profilePath,
                popularity = popularity,
                name = name,
                isAdult = adult
            )
        }
    }
}