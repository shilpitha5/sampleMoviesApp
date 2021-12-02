package com.example.movieapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.movieapp.repositories.TrendingMovieRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var movie: TrendingMovieRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            try {
                val response = movie.getTrendingMovie()
                Log.d("log", "response::::$response")
                Log.i("name", response.page.toString())
                Log.i("name", response.results[0].title)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}