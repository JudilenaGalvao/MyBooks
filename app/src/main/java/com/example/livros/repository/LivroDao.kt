package com.example.livros.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.livros.model.Livro


@Dao
interface LivroDao {

    @Query("SELECT * FROM livro")
    fun getAll(): List<Livro>

    @Insert
    fun insert(livro:Livro)
}