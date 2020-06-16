package com.we.movieapp.data.repository

import com.we.movieapp.data.entities.persons.RemoteResult
import com.we.movieapp.data.network.ServiceApi
import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.data.mapper.MovieMapper
import com.we.movieapp.data.mapper.PersonMapper
import com.we.movieapp.data.mapper.TVMapper
import com.we.movieapp.domain.entities.PersonEntity
import com.we.movieapp.domain.entities.TvEntity
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val serviceApi: ServiceApi,
    private val mapper: MovieMapper,
    private val personMapper: PersonMapper,
    private val tvMapper: TVMapper
) {


    fun getMovies(pageNumber: Int): Flowable<List<MovieEntity>> {

        return serviceApi.getMovies(pageNumber).map { getMovieResponse ->
            getMovieResponse.results.map { movieRemote ->
                mapper.mapFromRemoteToEntity(movieRemote)
            }
        }
    }

    fun getPersons(pageNumber: Int): Flowable<List<PersonEntity>> {

        return serviceApi.getPersons(pageNumber).map { getPersonsResponse ->
            getPersonsResponse.results.map { movieRemote ->
                personMapper.mapFromRemoteToEntity(movieRemote)
            }
        }.toFlowable()
    }

    fun getTopRatedMovies(pageNumber: Int): Flowable<List<MovieEntity>> {
        return serviceApi.getTopRatedMovies(pageNumber).map { response ->
            response.results.map { movies ->
                mapper.mapFromRemoteToEntity(movies)
            }
        }
    }

    fun getMovie(pageNumber: Int): Flowable<MovieEntity> {

        return serviceApi.getMovie(pageNumber).map { movieRemote ->
            mapper.mapFromRemoteToEntity(movieRemote)
        }.toFlowable()

    }

    fun getSimilarMovies(movieId: Int): Flowable<List<MovieEntity>> {

        return serviceApi.getSimilarMovies(movieId).map { movie ->
            movie.results.map { m -> mapper.mapFromRemoteToEntity(m) }
        }.toFlowable()
    }

    fun getRecommendationMovies(movieId: Int): Flowable<List<MovieEntity>> {

        return serviceApi.getRecommendationMovies(movieId).map { movieList ->
            movieList.results.map { movies ->
                mapper.mapFromRemoteToEntity(movies)
            }
        }.toFlowable()
    }

    fun getTvs(pageNumber: Int): Flowable<List<TvEntity>>{

        return serviceApi.getTVs(pageNumber).map { tvs ->
            tvs.results.map { tv ->
                tvMapper.mapFromRemoteToEntity(tv)
            }
        }.toFlowable()
    }
}