package com.example.zfinances.domain.model

data class Cartao(
    val id: Long = 0,
    val apelido: String,
    val banco: String,
    val limite: Double,
    val diaFechamento: Int,
    val diaPagamento: Int
)
