package com.example.avatar.services

import com.example.avatar.models.AvatarCharacter
import com.example.avatar.models.AvatarCharacterDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

interface ApiService {
    @GET("characters")
    fun getCharacters(
        @Query("perPage") perPage: String
    ): Call<List<AvatarCharacter>>

    @GET("characters/{id}")
    fun getCharacterById(
        @Path("id") id: String
    ): Call<AvatarCharacterDetail>
}