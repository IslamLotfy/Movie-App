package com.we.movieapp.data.entities.persons


import com.google.gson.annotations.SerializedName
import com.we.movieapp.domain.entities.PersonEntity

data class RemoteResult(
    @SerializedName("adult")
    override val isAdult: Boolean,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("id")
    override val id: Int,
    @SerializedName("known_for")
    val knownFor: List<KnownFor>,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("name")
    override val name: String,
    @SerializedName("popularity")
    override val popularity: Double,
    @SerializedName("profile_path")
    override val profilePath: String
):PersonEntity