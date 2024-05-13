package com.example.avatar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.avatar.databinding.ActivityCharacterBinding
import com.example.avatar.databinding.ActivityMainBinding
import com.example.avatar.models.AvatarCharacter
import com.example.avatar.models.AvatarCharacterDetail
import com.example.avatar.services.ApiService
import com.example.avatar.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val characterId = intent.extras?.getString("id").orEmpty()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val call: Call<AvatarCharacterDetail> = apiService.getCharacterById(characterId)

        call.enqueue(object: Callback<AvatarCharacterDetail> {
            override fun onResponse(
                p0: Call<AvatarCharacterDetail>,
                response: Response<AvatarCharacterDetail>
            ) {
                response.body()?.let { avatarCharacter ->
                    binding.tvName.text = avatarCharacter.name
                    binding.tvGenreValue.text = avatarCharacter.gender
                    binding.tvProfessionValue.text = avatarCharacter.profession
                    binding.tvPositionValue.text = avatarCharacter.position


                    if (!avatarCharacter.weapon.isNullOrBlank()) {
                        if (avatarCharacter.weapon.contains("Air"))
                            binding.ivAir.setImageResource(R.drawable.air_active)

                        if (avatarCharacter.weapon.contains("Water"))
                            binding.ivWater.setImageResource(R.drawable.water_active)

                        if (avatarCharacter.weapon.contains("Fire"))
                            binding.ivFire.setImageResource(R.drawable.fire_active)

                        if (avatarCharacter.weapon.contains("Earth"))
                            binding.ivEarth.setImageResource(R.drawable.earth_active)
                    }
                    Glide.with(binding.imageView3.context)
                        .load(avatarCharacter.photo)
                        .into(binding.imageView3)
                }
            }

            override fun onFailure(p0: Call<AvatarCharacterDetail>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}