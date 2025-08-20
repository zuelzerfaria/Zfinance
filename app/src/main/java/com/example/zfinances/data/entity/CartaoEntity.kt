package com.example.zfinances.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cartoes")
data class CartaoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val apelido: String,
    val banco: String,
    val limite: Double,
    val diaFechamento: Int, // Dia do mês (1-31)
    val diaPagamento: Int   // Dia do mês (1-31)
)
