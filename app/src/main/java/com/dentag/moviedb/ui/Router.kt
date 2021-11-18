package com.dentag.moviedb.ui

import com.dentag.moviedb.entities.Movie

interface Router {
    fun openMovie(movie: Movie)
}