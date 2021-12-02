package com.example.movieapp.repositories

import com.example.movieapp.models.Paginated
import com.example.movieapp.models.TrendingResult

interface TrendingMovieRepository {
    suspend fun getTrendingMovie(): Paginated<TrendingResult>
}
