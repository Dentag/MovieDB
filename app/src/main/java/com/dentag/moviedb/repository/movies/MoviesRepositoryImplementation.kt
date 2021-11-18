package com.dentag.moviedb.repository.movies

import com.dentag.moviedb.datasources.MovieDatasource
import com.dentag.moviedb.datasources.MovieRemoteDatasource
import com.dentag.moviedb.entities.Movie
import io.reactivex.rxjava3.core.Single

class MoviesRepositoryImplementation(
    private val remoteDatasource: MovieDatasource = MovieRemoteDatasource()
) : MoviesRepository {
    override fun getMovies(page: Int): Single<List<Movie>> {
        return remoteDatasource.getMoviesPage(page)
    }
}