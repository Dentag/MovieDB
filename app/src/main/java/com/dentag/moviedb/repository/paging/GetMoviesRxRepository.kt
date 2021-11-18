package com.dentag.moviedb.repository.paging

import androidx.paging.PagingData
import com.dentag.moviedb.entities.Movie
import io.reactivex.rxjava3.core.Flowable

interface GetMoviesRxRepository {
    fun getMovies(): Flowable<PagingData<Movie>>
}