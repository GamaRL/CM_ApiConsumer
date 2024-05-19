package com.example.avatar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

    private lateinit var binding: ActivityMainBinding
    private var characterList : List<AvatarCharacter> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fetchData()
    }

    override fun onStart() {
        super.onStart()

        if (characterList.isEmpty())
            fetchData()
    }

    private fun fetchData() {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val call : Call<List<AvatarCharacter>> = apiService.getCharacters("perPage=497")

        call.enqueue(object: Callback<List<AvatarCharacter>>{
            override fun onResponse(
                p0: Call<List<AvatarCharacter>>,
                response: Response<List<AvatarCharacter>>
            ) {
                response.body()?.let {
                        avatarCharacters ->
                    val characterAdapter = AvatarCharacterAdapter(avatarCharacters, ::showDetails)
                    characterList = avatarCharacters

                    binding.rvMain.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = characterAdapter
                    }
                }
            }

            override fun onFailure(p0: Call<List<AvatarCharacter>>, p1: Throwable) {
                val intent = Intent(this@MainActivity, ConnectionErrorActivity::class.java)

                startActivity(intent)
            }
        })
    }

    fun showDetails(character: AvatarCharacter) {
        val intent = Intent(this, CharacterActivity::class.java)

        intent.putExtra("id", character.id)

        startActivity(intent)

    }
}