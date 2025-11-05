package com.example.movieapi.api

data class MovieDetail(
    val Title: String,        // Movie title
    val Year: String,         // Release year
    val Rated: String,        // Rating (e.g., PG-13)
    val Released: String,     // Release date
    val Runtime: String,      // Runtime (e.g., 136 min)
    val Genre: String,        // Genre (e.g., Action, Adventure)
    val Director: String,     // Director
    val Writer: String,       // Writer
    val Actors: String,       // Actors/Stars
    val Plot: String,         // Plot summary
    val Language: String,     // Language (e.g., English)
    val Country: String,      // Country of origin
    val Poster: String,       // Movie poster URL
    val Ratings: List<MovieRating>, // Movie ratings from different sources
    val imdbRating: String,   // IMDb rating
    val imdbVotes: String,    // IMDb votes
    val imdbID: String        // IMDb ID (e.g., tt3896198)
)

data class MovieRating(
    val Source: String,       // Rating source (e.g., IMDb, Rotten Tomatoes)
    val Value: String         // Rating value (e.g., 7.6/10)
)
