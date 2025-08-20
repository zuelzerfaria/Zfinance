package com.example.zfinances.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "assinaturas",
    foreignKeys = [
        ForeignKey(
            entity = CartaoEntity::class,
            parentColumns = ["id"],
            childColumns = ["cartaoId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["cartaoId"])]
)
data class AssinaturaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    val valor: Double,
    val tipoRecorrencia: TipoRecorrencia, // MENSAL ou ANUAL
    val diaVencimento: Int, // Para MENSAL: dia do mês (1-31), Para ANUAL: dia do ano (1-365)
    val mesVencimento: Int? = null, // Apenas para ANUAL (1-12)
    val cartaoId: Long,
    val ativo: Boolean = true
)

enum class TipoRecorrencia {
    MENSAL,
    ANUAL
}
