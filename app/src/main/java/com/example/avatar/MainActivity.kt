package com.example.avatar

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avatar.databinding.ActivityMainBinding
import com.example.avatar.models.AvatarCharacter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val chars = ArrayList<AvatarCharacter>()

        for (i in 1 .. 100) {
            chars.add(
                AvatarCharacter(
                    "5cf5679a915ecad153ab68d$i",
                    "This is Aang $i",
                    "Earth Kingdom Air Force"
                )
            )

            Log.i(this.javaClass.toString(),i.toString())
        }

        val adapterAvatar = AvatarCharacterAdapter(chars)

        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = adapterAvatar
        }
    }
}