package com.example.zfinances.domain.model

data class Assinatura(
    val id: Long = 0,
    val nome: String,
    val valor: Double,
    val tipoRecorrencia: TipoRecorrencia,
    val diaVencimento: Int,
    val mesVencimento: Int? = null,
    val cartaoId: Long,
    val ativo: Boolean = true
)

enum class TipoRecorrencia {
    MENSAL,
    ANUAL
}
