package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityDisplayMessageBinding

class DisplayMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

// cargamos los datos en los campos asignados
        val rNombre = intent.getStringExtra("mNombre")
        val rApellido = intent.getStringExtra("mApellido")
        val rTelefono = intent.getStringExtra("mTelefono")
        binding.dmTvNombre.apply { text = rNombre }
        binding.dmTvApellido.apply{ text = rApellido}
        binding.dmTvTelefono.apply { text = rTelefono }

        // creamos la funcion y el llamado a la misma desde el boton
        binding.dmButton.setOnClickListener{respuesta()}
    }
    private fun respuesta(){
    val textoRespuesta = binding.dmEtNewMessage.text.toString()
        val intentcito = Intent(this,MainActivity::class.java).apply{
            putExtra("respuesta",textoRespuesta)
        }
        startActivity(intentcito)
    }
}