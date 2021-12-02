package com.example.movieapp.repositories

import com.example.movieapp.data.network.api.ApiService
import com.example.movieapp.models.Paginated
import com.example.movieapp.models.TrendingResult
import javax.inject.Inject

class TrendingMovieRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    TrendingMovieRepository {
    override suspend fun getTrendingMovie(): Paginated<TrendingResult> =
        apiService.getTrendingMovie()
}
