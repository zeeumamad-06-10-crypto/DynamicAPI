package com.example.myfristapi
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapi.api.Movie
import com.example.movieapi.api.RetrofitInstance
import com.example.movieapi.adapter.MovieAdapter
import com.example.myfristapi.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movieAdapter = MovieAdapter { movie ->
        // Handle movie item click (e.g., navigate to movie detail)
        Toast.makeText(this, "Clicked: ${movie.Title}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = movieAdapter

        // Fetch popular movies
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.searchMovies(
                    query = "Guardians of the Galaxy Vol. 2", // Replace with movie name or query
                    apiKey = "f5de7163"  // OMDb API key
                )

                if (response.isSuccessful) {
                    val movieList = response.body()?.Search ?: emptyList()  // Handle the Search response
                    movieAdapter.submitList(movieList)
                } else {
                    Log.e("API_ERROR", "Failed to fetch: ${response.message()}")
                    Toast.makeText(this@MainActivity, "Failed to fetch popular movies", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Error: ${e.message}")
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

