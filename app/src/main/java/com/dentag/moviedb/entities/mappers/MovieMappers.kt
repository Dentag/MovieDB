package com.dentag.moviedb.entities.mappers

import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.entities.api.MovieDTO
import com.dentag.moviedb.entities.api.responses.DiscoverMoviesResponse

fun MovieDTO.mapToMovie(): Movie {
    return Movie(
        poster_path,
        adult,
        overview,
        release_date,
        id,
        title,
        vote_average
    )
}

fun DiscoverMoviesResponse.mapToMovies(): List<Movie> {
    return results.map { it.mapToMovie() }
}

