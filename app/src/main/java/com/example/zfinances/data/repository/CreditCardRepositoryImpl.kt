package com.example.zfinances.data.repository

import com.example.zfinances.data.database.dao.CreditCardDao
import com.example.zfinances.data.database.entities.CreditCardEntity
import com.example.zfinances.domain.model.CreditCard
import com.example.zfinances.domain.repository.CreditCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditCardRepositoryImpl @Inject constructor(
    private val creditCardDao: CreditCardDao
) : CreditCardRepository {

    override fun getAllActiveCreditCards(): Flow<List<CreditCard>> {
        return creditCardDao.getAllActiveCreditCards().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    override fun getAllCreditCards(): Flow<List<CreditCard>> {
        return creditCardDao.getAllCreditCards().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    override suspend fun getCreditCardById(id: Long): CreditCard? {
        return creditCardDao.getCreditCardById(id)?.toDomainModel()
    }

    override suspend fun insertCreditCard(creditCard: CreditCard): Long {
        return creditCardDao.insertCreditCard(creditCard.toEntity())
    }

    override suspend fun updateCreditCard(creditCard: CreditCard) {
        creditCardDao.updateCreditCard(creditCard.toEntity())
    }

    override suspend fun deleteCreditCard(creditCard: CreditCard) {
        creditCardDao.deleteCreditCard(creditCard.toEntity())
    }

    override suspend fun deactivateCreditCard(id: Long) {
        creditCardDao.deactivateCreditCard(id)
    }
}

// Extension functions para conversão entre domain e data models
private fun CreditCardEntity.toDomainModel(): CreditCard {
    return CreditCard(
        id = id,
        nickname = nickname,
        bank = bank,
        closingDay = closingDay,
        paymentDay = paymentDay,
        creditLimit = creditLimit,
        isActive = isActive
    )
}

private fun CreditCard.toEntity(): CreditCardEntity {
    return CreditCardEntity(
        id = id,
        nickname = nickname,
        bank = bank,
        closingDay = closingDay,
        paymentDay = paymentDay,
        creditLimit = creditLimit,
        isActive = isActive
    )
}
