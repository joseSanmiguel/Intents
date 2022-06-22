package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityMainBinding


const val EXTRA_MESSAGE = "com.example.intents.MESSAGE"
class MainActivity : AppCompatActivity() {

    //call view binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //call function sendMessage() after click on button.
        binding.button.setOnClickListener{sendMessage()}
    }
    //function to make and intent which has information to send to another Activity
    private fun sendMessage(){
        val campo = binding.etNombre
        val message = campo.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}