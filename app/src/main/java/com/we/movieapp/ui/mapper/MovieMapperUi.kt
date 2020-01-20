package com.we.movieapp.ui.mapper

import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.ui.entities.MovieUiModel

class MovieMapperUi: MapFromEntityToUi<MovieEntity, MovieUiModel>{

    override fun mapToUiModel(model: MovieEntity): MovieUiModel {
        with(model) {
            return MovieUiModel(
                id = id,
                title = title,
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                posterPath = posterPath,
                releaseDate = releaseDate,
                voteAverage = voteAverage,
                isAdult = isAdult
            )
        }
    }

    override fun mapToUiModelList(model: List<MovieEntity>): List<MovieUiModel> {
        return model.map {
            with(it) {
                MovieUiModel(
                    id = id,
                    title = title,
                    overview = overview,
                    originalLanguage = originalLanguage,
                    originalTitle = originalTitle,
                    posterPath = posterPath,
                    releaseDate = releaseDate,
                    voteAverage = voteAverage,
                    isAdult = isAdult
                )
            }
        }
    }

}