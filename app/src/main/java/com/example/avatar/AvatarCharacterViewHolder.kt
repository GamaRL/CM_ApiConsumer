package com.example.avatar

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.avatar.databinding.ItemListBinding
import com.example.avatar.models.AvatarCharacter
import com.example.avatar.models.AvatarCharacterDetail

class AvatarCharacterViewHolder(private val binding: ItemListBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun imageView () : ImageView {
        return binding.imageView
    }

    fun bind(character: AvatarCharacter, listener: (AvatarCharacter) -> Unit) {
        binding.apply {
            tvName.text = character.name
            tvAffiliation.text = character.affiliation?.trim()
        }
        binding.root.setOnClickListener {
            listener(character)
        }
    }
}
