package com.dentag.moviedb.ui.movielist

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.repository.paging.GetMoviesRxRepository
import com.dentag.moviedb.repository.paging.GetMoviesRxRepositoryImpl
import io.reactivex.rxjava3.core.Flowable

class MovieListViewModel(
    private val repository: GetMoviesRxRepository = GetMoviesRxRepositoryImpl()
) : ViewModel() {
    fun getMovies(): Flowable<PagingData<Movie>> {
        return repository
            .getMovies()
    }
}