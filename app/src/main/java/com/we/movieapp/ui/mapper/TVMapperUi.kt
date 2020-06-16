package com.we.movieapp.ui.mapper

import com.we.movieapp.domain.entities.TvEntity
import com.we.movieapp.ui.entities.TvUiModel

class TVMapperUi : MapFromEntityToUi<TvEntity, TvUiModel>{

    override fun mapToUiModel(model: TvEntity): TvUiModel {
        with(model) {
            return TvUiModel(
                id = id,
                name = name,
                originalName = originalName,
                posterPath = posterPath,
                overview = overview
            )
        }
    }

    override fun mapToUiModelList(model: List<TvEntity>): List<TvUiModel> {
        return model.map {
            with(it) {
                TvUiModel(
                    id = id,
                    name = name,
                    originalName = originalName,
                    posterPath = posterPath,
                    overview = overview
                )
            }
        }
    }

}