package com.dentag.moviedb.ui.movielist

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dentag.moviedb.databinding.ItemMovieBinding
import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.extensions.colorByRating
import com.dentag.moviedb.network.Network

class MovieViewHolder(
    private val binding: ItemMovieBinding,
    private val onMovieClickListener: (Movie) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        itemView.setOnClickListener { onMovieClickListener(movie) }
        with(binding) {
            itemMovieTitle.text = movie.title
            itemMovieDate.text = movie.releaseDate
            itemMovieRating.colorByRating(movie.voteAverage)
            itemMovieRating.text = movie.voteAverage.toString()
            movie.posterPath?.let { path ->
                val posterUrl = "${Network.IMAGE_URL}$path"
                Glide.with(itemView)
                    .load(posterUrl)
                    .into(itemMoviePoster)
            }
        }
    }
}