package com.dentag.moviedb.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.dentag.moviedb.databinding.FragmentMovieBinding
import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.extensions.colorByRating
import com.dentag.moviedb.network.Network

class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieBinding
        .inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupArguments()
        initUI()
    }

    private fun setupArguments() {
        arguments?.let { args ->
            movie = args.getParcelable(MOVIE_EXTRA)
                ?: throw IllegalStateException("No movie found in arguments")
        }
    }

    private fun initUI() {
        with(binding) {
            fragmentMovieTitleTV.text = movie.title
            fragmentMovieOverviewTV.text = movie.overview
            fragmentMovieDateTV.text = movie.releaseDate
            fragmentMovieRatingTV.text = movie.voteAverage.toString()
            fragmentMovieRatingTV.colorByRating(movie.voteAverage)
            movie.posterPath?.let { path ->
                val posterUrl = "${Network.IMAGE_URL}$path"
                Glide.with(requireContext())
                    .load(posterUrl)
                    .into(fragmentMoviePosterIV)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val MOVIE_EXTRA = "com.dentag.moviedb.ui.movie.MovieFragment.MOVIE_EXTRA"

        fun newInstance(movie: Movie): MovieFragment {
            return MovieFragment().apply {
                arguments = bundleOf(
                    MOVIE_EXTRA to movie
                )
            }
        }
    }
}