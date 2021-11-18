package com.dentag.moviedb.repository.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.paging.MoviePagingSource
import io.reactivex.rxjava3.core.Flowable

class GetMoviesRxRepositoryImpl(
    private val pagingSource: MoviePagingSource = MoviePagingSource()
) : GetMoviesRxRepository {
    override fun getMovies(): Flowable<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = { pagingSource }
        ).flowable
    }
}