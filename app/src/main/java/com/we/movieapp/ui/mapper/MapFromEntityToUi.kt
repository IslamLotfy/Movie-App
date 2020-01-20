package com.we.movieapp.ui.mapper

interface MapFromEntityToUi<E, U> {
    fun mapToUiModel(model: E): U
    fun mapToUiModelList(model: List<E>): List<U>
}