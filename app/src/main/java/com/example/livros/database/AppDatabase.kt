package com.example.livros.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.livros.model.Livro
import com.example.livros.repository.LivroDao

@Database(entities = arrayOf(Livro::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun livroDao() : LivroDao
}