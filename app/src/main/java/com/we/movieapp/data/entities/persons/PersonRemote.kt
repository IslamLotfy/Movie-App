package com.we.movieapp.data.entities.persons


import com.google.gson.annotations.SerializedName

data class PersonRemote(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<RemoteResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)