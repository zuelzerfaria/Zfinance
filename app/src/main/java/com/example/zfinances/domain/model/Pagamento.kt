package com.example.zfinances.domain.model

import java.time.LocalDate

data class Pagamento(
    val id: Long = 0,
    val tipoCompra: String,
    val descricao: String,
    val valor: Double,
    val data: LocalDate,
    val numeroParcelas: Int,
    val cartaoId: Long
)
