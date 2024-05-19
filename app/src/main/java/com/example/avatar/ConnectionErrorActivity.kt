package com.example.avatar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.avatar.databinding.ActivityConnectionErrorBinding

class ConnectionErrorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConnectionErrorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConnectionErrorBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.bReload.setOnClickListener{
            finish()
        }
    }
}