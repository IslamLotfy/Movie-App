package com.we.movieapp.data.entities.tvs


import com.google.gson.annotations.SerializedName

data class TvsRemote(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<RemoteTvsResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)