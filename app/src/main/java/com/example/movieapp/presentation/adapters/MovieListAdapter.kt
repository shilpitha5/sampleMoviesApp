package com.example.movieapp.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemMovieBinding
import com.example.movieapp.models.TrendingResult

class MovieListAdapter: RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    class MovieListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    val diffCallback = object : DiffUtil.ItemCallback<TrendingResult>() {

        override fun areItemsTheSame(oldItem: TrendingResult, newItem: TrendingResult): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: TrendingResult, newItem: TrendingResult): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun getChangePayload(oldItem: TrendingResult, newItem: TrendingResult): Any? {
            return super.getChangePayload(oldItem, newItem)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie = movieList[position]
        val binding = ItemMovieBinding.bind(holder.itemView)

        holder.itemView.apply {
            binding.title.text = movie.title
            binding.overview.text = movie.overview

            Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+movie.poster_path).into(binding.imgMoviePoster)
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    val differ = AsyncListDiffer(this, diffCallback)

    var movieList: List<TrendingResult>
        get() = differ.currentList
        set(value) = differ.submitList(value)

}