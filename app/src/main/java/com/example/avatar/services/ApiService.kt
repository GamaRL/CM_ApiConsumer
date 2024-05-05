package com.example.avatar.services

import com.example.avatar.models.AvatarCharacter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getCharacters(
        @Url url: String,
        @Query("perPage") perPage: String
    ): Call<List<AvatarCharacter>>
}