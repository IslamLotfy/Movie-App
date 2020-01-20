package com.we.movieapp.domain.mapper


interface MapFromRemoteToEntity<R , E> {

    fun mapFromRemoteToEntity(model: R): E
//    fun mapFromLocalToEntity(model: L): E
//    fun mapFromRemoteToLocal(model: R): L

}