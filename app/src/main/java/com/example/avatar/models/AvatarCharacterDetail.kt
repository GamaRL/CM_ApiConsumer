package com.example.avatar.models

import com.google.gson.annotations.SerializedName

data class AvatarCharacterDetail (
    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("affiliation")
    val affiliation: String?,

    @SerializedName("photoUrl")
    val photo: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("position")
    val position: String,

    @SerializedName("profession")
    val profession: String,
)