package com.we.movieapp.domain.entities

interface PersonEntity {
    val id: Int
    val popularity: Double?
    val name: String?
    val profilePath: String?
    val isAdult: Boolean?
}