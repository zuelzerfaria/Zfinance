package com.example.zfinances.data.dao

import androidx.room.*
import com.example.zfinances.data.entity.CartaoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartaoDao {

    @Query("SELECT * FROM cartoes ORDER BY apelido ASC")
    fun getAllCartoes(): Flow<List<CartaoEntity>>

    @Query("SELECT * FROM cartoes WHERE id = :id")
    suspend fun getCartaoById(id: Long): CartaoEntity?

    @Insert
    suspend fun insertCartao(cartao: CartaoEntity): Long

    @Update
    suspend fun updateCartao(cartao: CartaoEntity)

    @Delete
    suspend fun deleteCartao(cartao: CartaoEntity)

    @Query("DELETE FROM cartoes WHERE id = :id")
    suspend fun deleteCartaoById(id: Long)
}
