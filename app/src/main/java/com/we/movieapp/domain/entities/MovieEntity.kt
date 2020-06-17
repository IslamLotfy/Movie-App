package com.we.movieapp.domain.entities

import com.google.gson.annotations.SerializedName

interface  MovieEntity {
    val id: Int
    val overview: String?
    val originalLanguage: String?
    val originalTitle: String?
    val title: String?
    val posterPath: String?
    val releaseDate: String?
    val popularity: Double?
    val voteAverage: Double?
    val isAdult: Boolean?
    val voteCount: Int?
    val backdropPath: String
    val genreIds: List<Int>
    val video: Boolean
}