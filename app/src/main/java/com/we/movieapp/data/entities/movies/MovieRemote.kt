package com.we.movieapp.data.entities.movies


import com.google.gson.annotations.SerializedName
import com.we.movieapp.domain.entities.MovieEntity

data class MovieRemote(
    @SerializedName("adult")
    override val isAdult: Boolean,
    @SerializedName("backdrop_path")
    override val backdropPath: String,
    @SerializedName("genre_ids")
    override val genreIds: List<Int>,
    @SerializedName("id")
    override val id: Int,
    @SerializedName("original_language")
    override val originalLanguage: String,
    @SerializedName("original_title")
    override val originalTitle: String,
    @SerializedName("overview")
    override val overview: String,
    @SerializedName("popularity")
    override val popularity: Double,
    @SerializedName("poster_path")
    override val posterPath: String,
    @SerializedName("release_date")
    override val releaseDate: String,
    @SerializedName("title")
    override val title: String,
    @SerializedName("video")
    override val video: Boolean,
    @SerializedName("vote_average")
    override val voteAverage: Double,
    @SerializedName("vote_count")
    override val voteCount: Int
): MovieEntity