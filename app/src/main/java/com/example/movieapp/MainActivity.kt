package com.example.movieapp

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.adapters.MovieListAdapter
import com.example.movieapp.repositories.TrendingMovieRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movie: TrendingMovieRepository

    private lateinit var binding: ActivityMainBinding

    lateinit var movieListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieListAdapter = MovieListAdapter()

        val dividerItemDecoration = DividerItemDecoration(
            this@MainActivity,
            LinearLayout.VERTICAL
        )
        binding.rvMovies.addItemDecoration(dividerItemDecoration)

        binding.rvMovies.adapter = movieListAdapter

        lifecycleScope.launch {
            try {
                val response = movie.getTrendingMovie()
                binding.empty.isVisible = response.results.isEmpty()
                binding.rvMovies.isVisible = true
                if (response.results.isNotEmpty()) {
                    movieListAdapter.movieList = response.results
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}