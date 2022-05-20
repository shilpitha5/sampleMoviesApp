package com.example.movieapp.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingResult(
    @SerialName("title")
    val title: String = "",
    @SerialName("overview")
    val overview: String = "",
    @SerialName("release_date")
    val releaseDate: String = "",
    @SerialName("vote_average")
    val score: Float = 0F,
    @SerialName("popularity")
    val popularity: Float = 0F,
    @SerialName("poster_path")
    val poster_path: String,
    @SerialName("backdrop_path")
    val backdropPath: String,
)
