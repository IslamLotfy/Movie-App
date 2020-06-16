package com.we.movieapp.data.mapper

import com.we.movieapp.data.entities.tvs.RemoteTvsResult
import com.we.movieapp.domain.entities.TvEntity

class TVMapper : MapFromRemoteToEntity<RemoteTvsResult, TvEntity> {
    override fun mapFromRemoteToEntity(model: RemoteTvsResult): TvEntity {
        with(model) {
            return TvEntity(
                id = id,
                name = name,
                posterPath = posterPath,
                originalName = originalName,
                overview = overview
            )
        }
    }
}