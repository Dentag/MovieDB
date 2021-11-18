package com.dentag.moviedb.ui.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.dentag.moviedb.databinding.ItemMovieBinding
import com.dentag.moviedb.entities.Movie

class MovieAdapter(
    private val onMovieClickListener: (Movie) -> Unit
) : PagingDataAdapter<Movie, MovieViewHolder>(movieDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding, onMovieClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val movieDiffer = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.posterPath == newItem.posterPath &&
                        oldItem.title == newItem.title &&
                        oldItem.voteAverage == newItem.voteAverage
            }
        }
    }
}