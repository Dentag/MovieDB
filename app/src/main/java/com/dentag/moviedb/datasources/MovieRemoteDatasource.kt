package com.dentag.moviedb.datasources

import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.entities.mappers.mapToMovies
import com.dentag.moviedb.network.MovieApi
import com.dentag.moviedb.network.Network
import io.reactivex.rxjava3.core.Single

class MovieRemoteDatasource(
    private val api: MovieApi = Network.movieApi
) : MovieDatasource {
    override fun getMoviesPage(page: Int): Single<List<Movie>> {
        return api.getMovies(page).map { it.mapToMovies() }
    }
}