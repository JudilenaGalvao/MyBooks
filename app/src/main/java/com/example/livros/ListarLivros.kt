package com.example.livros

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.livros.database.AppDatabase
import com.example.livros.databinding.ActivityListarLivrosBinding
import com.example.livros.model.Livro

class ListarLivros : AppCompatActivity() {

    private lateinit var binding: ActivityListarLivrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "livro.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

        val listLivros:List<Livro> = db.livroDao().getAll()


        if(listLivros.isNotEmpty()){

            var cont = 0

            fun updateBookData() {
                val livro = listLivros[cont]
                binding.tvTitulo.text = livro.titulo
                binding.tvAutor.text = livro.autor
                binding.tvAno.text = livro.ano.toString()
                binding.tvNota.text = livro.nota.toString()
            }

            updateBookData()

            binding.btnProximo.setOnClickListener {
                if (cont + 1 < listLivros.size) {
                    cont++
                    updateBookData()
                } else {
                    Toast.makeText(this, "Sem livros após esse!", Toast.LENGTH_SHORT).show()
                }
            }

            binding.btnAnterior.setOnClickListener {
                if (cont - 1 >= 0) {
                    cont--
                    updateBookData()
                } else {
                    Toast.makeText(this, "Sem livros antes desse!", Toast.LENGTH_SHORT).show()
                }
            }

        }



    }
}