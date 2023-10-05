package com.example.livros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.livros.database.AppDatabase
import com.example.livros.databinding.ActivityCadastrarLivroBinding
import com.example.livros.model.Livro

class CadastrarLivro : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarLivroBinding

    var titulo:String=""
    var autor:String = ""
    var ano:Int = 0
    var nota:Float =0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "livro.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()


        binding.btnSalvar.setOnClickListener {
            titulo = binding.editTitulo.text.toString()
            autor = binding.editAutor.text.toString()
            ano = binding.editAno.text.toString().toInt()
            nota = binding.ratingBar.rating

            var livro:Livro = Livro(titulo, autor, ano, nota)
            db.livroDao().insert(livro)
            finish()

        }

        binding.btnCancelar.setOnClickListener {
            finish()
        }


    }
}