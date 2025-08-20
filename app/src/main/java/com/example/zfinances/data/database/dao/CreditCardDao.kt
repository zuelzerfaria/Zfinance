package com.example.zfinances.data.database.dao

import androidx.room.*
import com.example.zfinances.data.database.entities.CreditCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CreditCardDao {

    @Query("SELECT * FROM credit_cards WHERE isActive = 1 ORDER BY nickname ASC")
    fun getAllActiveCreditCards(): Flow<List<CreditCardEntity>>

    @Query("SELECT * FROM credit_cards ORDER BY nickname ASC")
    fun getAllCreditCards(): Flow<List<CreditCardEntity>>

    @Query("SELECT * FROM credit_cards WHERE id = :id")
    suspend fun getCreditCardById(id: Long): CreditCardEntity?

    @Insert
    suspend fun insertCreditCard(creditCard: CreditCardEntity): Long

    @Update
    suspend fun updateCreditCard(creditCard: CreditCardEntity)

    @Delete
    suspend fun deleteCreditCard(creditCard: CreditCardEntity)

    @Query("UPDATE credit_cards SET isActive = 0 WHERE id = :id")
    suspend fun deactivateCreditCard(id: Long)
}
