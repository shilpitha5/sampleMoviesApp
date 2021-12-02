package com.example.movieapp.di

import com.example.movieapp.repositories.TrendingMovieRepository
import com.example.movieapp.repositories.TrendingMovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTrendingMovieRepository(trendingMovieRepositoryImpl: TrendingMovieRepositoryImpl): TrendingMovieRepository

}
