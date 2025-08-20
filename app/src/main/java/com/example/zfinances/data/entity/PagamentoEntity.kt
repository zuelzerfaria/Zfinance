package com.example.zfinances.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "pagamentos",
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
data class PagamentoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val tipoCompra: String,
    val descricao: String,
    val valor: Double,
    val data: LocalDate,
    val numeroParcelas: Int,
    val cartaoId: Long
)
