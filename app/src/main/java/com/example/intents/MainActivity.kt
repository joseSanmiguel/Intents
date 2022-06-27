package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //llamamos el view binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //llamamos la funcion sendMessage() despues de cliquear el boton
        binding.button.setOnClickListener{sendMessage()}
        //cargamos los datos que provienen de la segunda activity
        val newRespuesta = intent.getStringExtra("respuesta")
        binding.tvconfirmacion.apply { text = newRespuesta }
    }
    //hacemos una funcion para el intent que es donde almacenamos los datos que queremos pasar
    private fun sendMessage(){
        val nombre = binding.etNombre.text.toString()
        val apellido = binding.etApellido.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
        putExtra("mNombre", nombre)
        putExtra("mApellido", apellido)
        putExtra("mTelefono", telefono)}
        //llamamos la variable intent que es la que nos llevara a la siguiente Activity segun el intent
        startActivity(intent)
    }
}