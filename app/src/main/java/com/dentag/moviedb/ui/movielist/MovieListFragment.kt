package com.dentag.moviedb.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dentag.moviedb.databinding.FragmentMovieListBinding
import com.dentag.moviedb.ui.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class MovieListFragment : Fragment() {
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private var movieAdapter: MovieAdapter? = null
    private lateinit var viewModel: MovieListViewModel
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieListBinding.inflate(layoutInflater, container, false)
        .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        viewModel.getMovies().subscribe { movieAdapter?.submitData(lifecycle, it) }
            .addTo(compositeDisposable)
    }

    private fun initRecycler() {
        movieAdapter = MovieAdapter() { movie ->
            (requireActivity() as Router).openMovie(movie)
        }
        with(binding.fragmentMovieListRecycler) {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        movieAdapter = null
        compositeDisposable.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}