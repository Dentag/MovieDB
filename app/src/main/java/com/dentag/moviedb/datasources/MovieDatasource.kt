package com.dentag.moviedb.datasources

import com.dentag.moviedb.entities.Movie
import io.reactivex.rxjava3.core.Single

interface MovieDatasource {
    fun getMoviesPage(page: Int): Single<List<Movie>>
}