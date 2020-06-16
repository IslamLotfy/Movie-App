package com.we.movieapp.data.mapper


interface MapFromRemoteToEntity<R , E> {

    fun mapFromRemoteToEntity(model: R): E
//    fun mapFromLocalToEntity(model: L): E
//    fun mapFromRemoteToLocal(model: R): L

}