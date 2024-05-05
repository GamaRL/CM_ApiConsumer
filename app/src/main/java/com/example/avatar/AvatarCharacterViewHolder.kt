package com.example.avatar

import androidx.recyclerview.widget.RecyclerView
import com.example.avatar.databinding.ItemListBinding
import com.example.avatar.models.AvatarCharacter

class AvatarCharacterViewHolder(private val binding: ItemListBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(character: AvatarCharacter) {
        binding.apply {
            tvName.text = character.name
            tvAffiliation.text = character.affiliation
        }
    }
}
