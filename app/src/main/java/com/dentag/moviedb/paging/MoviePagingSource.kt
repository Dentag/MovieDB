package com.dentag.moviedb.paging

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.repository.movies.MoviesRepository
import com.dentag.moviedb.repository.movies.MoviesRepositoryImplementation
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviePagingSource(
    private val moviesRepository: MoviesRepository = MoviesRepositoryImplementation()
) : RxPagingSource<Int, Movie>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Movie>> {
        val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
        return moviesRepository.getMovies(pageNumber)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, Movie>> { result ->
                val nextPageNumber = if (result.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                LoadResult.Page(
                    data = result,
                    prevKey = prevPageNumber,
                    nextKey = nextPageNumber
                )
            }
            .onErrorReturn { e ->
                LoadResult.Error(e)
            }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    companion object {
        private const val INITIAL_PAGE_NUMBER = 1
    }
}