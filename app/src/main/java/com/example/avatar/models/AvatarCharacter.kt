package com.example.avatar.models

import com.google.gson.annotations.SerializedName

data class AvatarCharacter (
    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("affiliation")
    val affiliation: String?,

    @SerializedName("photoUrl")
    val photo: String
)
