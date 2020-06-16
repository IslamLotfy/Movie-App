package com.we.movieapp.domain.entities

data class PersonEntity(

    val id: Int = 0,

    val popularity: Double = 0.0,

    val name: String? = null,

    val profilePath: String? = null,

    val isAdult: Boolean = false

)