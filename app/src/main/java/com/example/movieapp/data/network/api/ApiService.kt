package com.example.movieapp.data.network.api

import com.example.movieapp.models.Paginated
import com.example.movieapp.models.TrendingResult
import retrofit2.http.GET

interface ApiService {
    @GET("trending/Movie/Day")
    suspend fun getTrendingMovie(): Paginated<TrendingResult>
}
