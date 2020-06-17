package com.we.movieapp.data.entities.movies


import com.google.gson.annotations.SerializedName
import com.we.movieapp.domain.entities.MovieEntity

data class MoviesList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieRemote>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)