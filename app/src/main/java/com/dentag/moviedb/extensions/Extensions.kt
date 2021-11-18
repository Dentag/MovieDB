package com.dentag.moviedb.extensions

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.dentag.moviedb.R

fun TextView.colorByRating(voteAverage: Float) {
    val ratingColorRes = when {
        voteAverage > 7.5 -> R.color.green
        voteAverage > 6 -> R.color.gray
        else -> R.color.red
    }
    val ratingColor = ContextCompat.getColor(context, ratingColorRes)
    setTextColor(ratingColor)
}