package com.example.movieapi.api

data class MovieSearchResponse(
    val Search: List<Movie>,  // A list of movies returned from the search
    val totalResults: String, // Total number of search results
    val Response: String      // "True" if the request was successful, otherwise "False"
)
