package com.example.movieapi.api

import androidx.recyclerview.widget.DiffUtil

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    // Compare by unique item ID to check if two items are the same
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.imdbID == newItem.imdbID  // Assuming 'id' is the unique identifier for each movie
    }

    // Compare the contents of the two items to see if their data is the same
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem  // Checks if all fields of the movie are the same
    }
}
