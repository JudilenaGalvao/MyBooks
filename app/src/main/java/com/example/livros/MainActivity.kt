package com.example.livros

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.livros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener{
            val i = Intent(this, CadastrarLivro::class.java)
            startActivity(i)
        }

        binding.btnListar.setOnClickListener{
            val i = Intent(this, ListarLivros::class.java)
            startActivity(i)
        }

    }
}