package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityDisplayMessageBinding

class DisplayMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        binding.dmTvNombre.apply { text = message }
    }
}