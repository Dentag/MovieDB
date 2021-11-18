package com.dentag.moviedb.entities.api

class MovieDTO(
    val poster_path: String?,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val id: Int,
    val title: String,
    val vote_average: Float
)