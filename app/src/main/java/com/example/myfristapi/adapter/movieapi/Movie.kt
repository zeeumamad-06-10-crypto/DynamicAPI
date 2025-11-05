package com.example.movieapi.api

data class Movie(
    val Title: String,       // Movie title
    val Year: String,        // Movie release year
    val imdbID: String,      // IMDb ID (e.g., tt3896198)
    val Poster: String       // URL for the movie poster
)
