package com.example.zfinances.domain.model

data class CreditCard(
    val id: Long = 0,
    val nickname: String,
    val bank: String,
    val closingDay: Int, // Dia do mês que fecha a fatura (1-31)
    val paymentDay: Int, // Dia do mês que paga a fatura (1-31)
    val creditLimit: java.math.BigDecimal,
    val isActive: Boolean = true
)

enum class ExpenseCategory(val displayName: String) {
    MERCADO("Mercado"),
    IMPREVISTO("Imprevisto")
}
