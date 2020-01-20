package com.we.movieapp.domain.mapper

import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.data.entities.movies.MovieRemote

class MovieMapper : MapFromRemoteToEntity<MovieRemote, MovieEntity> {
    override fun mapFromRemoteToEntity(model: MovieRemote): MovieEntity {
        with(model) {
            return MovieEntity(
                id = id,
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                title = title,
                posterPath = posterPath,
                releaseDate = releaseDate,
                popularity = popularity,
                voteAverage = voteAverage,
                isAdult = adult,
                voteCount = voteCount
            )
        }
    }
}