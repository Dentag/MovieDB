package com.dentag.moviedb.repository.movies

import com.dentag.moviedb.entities.Movie
import io.reactivex.rxjava3.core.Single

interface MoviesRepository {
    fun getMovies(page: Int): Single<List<Movie>>
}