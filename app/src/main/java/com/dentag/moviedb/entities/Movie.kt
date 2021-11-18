package com.dentag.moviedb.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val posterPath: String?,
    val isAdult: Boolean,
    val overview: String,
    val releaseDate: String,
    val id: Int,
    val title: String,
    val voteAverage: Float
) : Parcelable