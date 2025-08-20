package com.example.zfinances.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val amount: BigDecimal,
    val category: String, // Mercado ou Imprevisto
    val creditCardId: Long, // Referência ao cartão de crédito usado
    val installments: Int = 1,
    val date: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

data class FinancialSummary(
    val totalExpenses: BigDecimal,
    val transactions: List<Transaction>,
    val expensesByCategory: Map<String, BigDecimal>,
    val expensesByCard: Map<Long, BigDecimal>
)
