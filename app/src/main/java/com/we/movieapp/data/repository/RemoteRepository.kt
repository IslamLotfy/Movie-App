package com.we.movieapp.data.repository

import com.we.movieapp.data.network.ServiceApi
import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.domain.mapper.MovieMapper
import io.reactivex.Flowable
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val serviceApi: ServiceApi, private val mapper: MovieMapper) {


//    fun getMovies(pageNumber: Int) = serviceApi.getMovies(pageNumber)

    fun getMovies(pageNumber: Int): Flowable<List<MovieEntity>> {

        return serviceApi.getMovies(pageNumber).map { getMovieResponse ->
            getMovieResponse.results.map { movieRemote ->
                mapper.mapFromRemoteToEntity(movieRemote)
            }
        }
    }
//    fun getMovies(pageNumber: Int): Flowable<List<MovieEntity>?> {
//
//        val localMovie =
//
//
//        val remoteMovie = if (pageNumber == 1) {
//            serviceApi.getMovies(pageNumber).map { getMovieResponse ->
//                getMovieResponse.movies?.map { movieRemote ->
//                    local.insertMovie(mapper.mapFromRemoteToLocal(movieRemote))
//                    mapper.mapFromRemoteToEntity(movieRemote)
//                }
//            }
//        } else {
//            remote.getMovies(pageNumber).map { getMovieResponse ->
//                getMovieResponse.movies?.map { movieRemote ->
//                    mapper.mapFromRemoteToEntity(movieRemote)
//                }
//            }
//        }
//
//        if (pageNumber == 1)
//            return Single.concat<List<MovieEntity>>(localMovie, remoteMovie)
//
//        return remoteMovie.toFlowable()
//    }


}