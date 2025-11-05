package com.example.movieapi.adapter

import com.example.myfristapi.databinding.ItemMovieBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieapi.api.Movie
import com.example.movieapi.api.MovieDiffCallback
import com.example.myfristapi.R  // Import the R class from your project

class MovieAdapter(private val onClick: (Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.titleText.text = movie.Title
            binding.posterImage.load(movie.Poster) {
                crossfade(true)
                placeholder(R.drawable.placeholder)  // Make sure you have a placeholder image in your resources
            }
            binding.root.setOnClickListener { onClick(movie) }
        }
    }
}
