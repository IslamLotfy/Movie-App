package com.we.movieapp.ui.mapper

import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.domain.entities.PersonEntity
import com.we.movieapp.ui.entities.MovieUiModel
import com.we.movieapp.ui.entities.PersonUiModel

class PersonMapperUi : MapFromEntityToUi<PersonEntity, PersonUiModel>{

    override fun mapToUiModel(model: PersonEntity): PersonUiModel {
        with(model) {
            return PersonUiModel(
                id = id,
                name = name,
                profilePath = profilePath,
                popularity = popularity,
                isAdult = isAdult
            )
        }
    }

    override fun mapToUiModelList(model: List<PersonEntity>): List<PersonUiModel> {
        return model.map {
            with(it) {
                PersonUiModel(
                    id = id,
                    name = name,
                    profilePath = profilePath,
                    popularity = popularity,
                    isAdult = isAdult
                )
            }
        }
    }

}