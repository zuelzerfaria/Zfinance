package com.example.zfinances.domain.repository

import com.example.zfinances.domain.model.CreditCard
import kotlinx.coroutines.flow.Flow

interface CreditCardRepository {

    fun getAllActiveCreditCards(): Flow<List<CreditCard>>

    fun getAllCreditCards(): Flow<List<CreditCard>>

    suspend fun getCreditCardById(id: Long): CreditCard?

    suspend fun insertCreditCard(creditCard: CreditCard): Long

    suspend fun updateCreditCard(creditCard: CreditCard)

    suspend fun deleteCreditCard(creditCard: CreditCard)

    suspend fun deactivateCreditCard(id: Long)
}
