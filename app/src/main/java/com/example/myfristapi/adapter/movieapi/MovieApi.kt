package com.example.movieapi.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    // Endpoint to fetch a movie by its IMDB ID
    @GET("/")
    suspend fun getMovieById(
        @Query("i") movieId: String,  // Movie ID (e.g., tt3896198)
        @Query("apikey") apiKey: String  // Your OMDb API key
    ): Response<Movie>

    // Endpoint to search for movies by title (optional)
    @GET("/")
    suspend fun searchMovies(
        @Query("s") query: String,  // Movie search query
        @Query("apikey") apiKey: String  // Your OMDb API key
    ): Response<MovieSearchResponse>
}
