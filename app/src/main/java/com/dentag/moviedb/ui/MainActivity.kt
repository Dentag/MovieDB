package com.dentag.moviedb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dentag.moviedb.R
import com.dentag.moviedb.databinding.ActivityMainBinding
import com.dentag.moviedb.entities.Movie
import com.dentag.moviedb.ui.movie.MovieFragment
import com.dentag.moviedb.ui.movielist.MovieListFragment

class MainActivity : AppCompatActivity(), Router {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(binding.mainFragmentContainer.id, MovieListFragment())
            .commitAllowingStateLoss()
    }

    override fun openMovie(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(binding.mainFragmentContainer.id, MovieFragment.newInstance(movie))
            .commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}