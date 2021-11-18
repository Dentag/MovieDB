package com.dentag.moviedb.network

import com.dentag.moviedb.entities.api.responses.DiscoverMoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    fun getMovies(
        @Query("page") pageNumber: Int,
    ): Single<DiscoverMoviesResponse>
}