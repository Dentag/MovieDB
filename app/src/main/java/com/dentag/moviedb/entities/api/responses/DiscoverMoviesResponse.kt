package com.dentag.moviedb.entities.api.responses

import com.dentag.moviedb.entities.api.MovieDTO

class DiscoverMoviesResponse(
    val page: Int,
    val results: List<MovieDTO>,
    val total_results: Int,
    val total_pages: Int
)