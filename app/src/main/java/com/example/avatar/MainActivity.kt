package com.example.avatar

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avatar.databinding.ActivityMainBinding
import com.example.avatar.models.AvatarCharacter
import com.example.avatar.services.ApiService
import com.example.avatar.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val call : Call<List<AvatarCharacter>> = apiService.getCharacters("characters?", "perPage=497")

        call.enqueue(object: Callback<List<AvatarCharacter>>{
            override fun onResponse(
                p0: Call<List<AvatarCharacter>>,
                response: Response<List<AvatarCharacter>>
            ) {
                Log.d("HOLA", "Respuesta recibida ${response.body()}")

                response.body()?.let {
                    avatarCharacters ->
                    val characterAdapter = AvatarCharacterAdapter(avatarCharacters)

                    binding.rvMain.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = characterAdapter
                    }
                }
            }

            override fun onFailure(p0: Call<List<AvatarCharacter>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "No hay conexión disponible", Toast.LENGTH_SHORT).show()
            }
        })
    }
}