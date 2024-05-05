package com.example.avatar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avatar.databinding.ItemListBinding
import com.example.avatar.models.AvatarCharacter

class AvatarCharacterAdapter(private val characters: List<AvatarCharacter>) : RecyclerView.Adapter<AvatarCharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarCharacterViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))

        return AvatarCharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: AvatarCharacterViewHolder, position: Int) {
        val character = characters[position]

        holder.bind(character)

        Glide.with(holder.itemView.context)
            .load(character.photo)
            .into(holder.imageView())
    }
}
