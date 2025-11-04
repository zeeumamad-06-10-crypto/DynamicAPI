package com.example.myfristapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfristapi.adapter.ProductAdapter
import com.example.myfristapi.api.ProductItem
import com.example.myfristapi.api.RetrofitInstance
import com.example.myfristapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFetch.setOnClickListener {
            val apiUrl = binding.etApiUrl.text.toString().trim()

            if (apiUrl.isNotBlank()) {
                fetchProducts(apiUrl)
            } else {
                Toast.makeText(this, "Enter API URL", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchProducts(url: String) {
        RetrofitInstance.getApi().getProducts(url)
            .enqueue(object : Callback<List<ProductItem>> {
                override fun onResponse(
                    call: Call<List<ProductItem>>,
                    response: Response<List<ProductItem>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val products = response.body()!!
                        binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.rvProducts.adapter = ProductAdapter(products)
                    } else {
                        Toast.makeText(this@MainActivity, "No data found", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<ProductItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
    }
}
