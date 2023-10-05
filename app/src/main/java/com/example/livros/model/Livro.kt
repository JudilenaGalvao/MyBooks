package com.example.livros.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Livro(
    var titulo:String,
    var autor:String,
    var ano:Int,
    var nota:Float
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}