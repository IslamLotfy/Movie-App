package com.we.movieapp.data.repository

import com.we.movieapp.data.network.ServiceApi
import com.we.movieapp.domain.entities.MovieEntity
import com.we.movieapp.data.mapper.TVMapper
import com.we.movieapp.domain.Repository
import com.we.movieapp.domain.entities.PersonEntity
import com.we.movieapp.domain.entities.TvEntity
import io.reactivex.Flowable
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val serviceApi: ServiceApi,
    private val tvMapper: TVMapper
) :Repository{


    override fun getMovies(pageNumber: Int): Flowable<List<MovieEntity>> {

        return serviceApi.getMovies(pageNumber).map { getMovieResponse ->
            getMovieResponse.results.map { movieRemote ->
               movieRemote
            }
        }
    }

    override fun getPersons(pageNumber: Int): Flowable<List<PersonEntity>> {

        return serviceApi.getPersons(pageNumber).map {
            it.results
        }
    }

    override fun getTopRatedMovies(pageNumber: Int): Flowable<List<MovieEntity>> {
        return serviceApi.getTopRatedMovies(pageNumber).map { response ->
            response.results.map { movies ->
               movies
            }
        }
    }

    override fun getMovie(pageNumber: Int): Flowable<MovieEntity> {

        return serviceApi.getMovie(pageNumber).map { movieRemote ->
           movieRemote
        }

    }

    override fun getSimilarMovies(movieId: Int): Flowable<List<MovieEntity>> {

        return serviceApi.getSimilarMovies(movieId).map {
            it.results
        }
    }

    override fun getRecommendationMovies(movieId: Int): Flowable<List<MovieEntity>> {

        return serviceApi.getRecommendationMovies(movieId,0).map {
            it.results
        }
    }

    override fun getTvs(pageNumber: Int): Flowable<List<TvEntity>>{

        return serviceApi.getTVs(pageNumber).map { tvs ->
            tvs.results.map { tv ->
                tvMapper.mapFromRemoteToEntity(tv)
            }
        }
    }
}