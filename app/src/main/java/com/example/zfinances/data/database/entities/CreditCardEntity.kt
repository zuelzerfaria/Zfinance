package com.example.zfinances.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "credit_cards")
data class CreditCardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nickname: String,
    val bank: String,
    val closingDay: Int,
    val paymentDay: Int,
    val creditLimit: BigDecimal,
    val isActive: Boolean = true
)
