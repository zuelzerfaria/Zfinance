package com.example.zfinances.data.repository

import com.example.zfinances.data.dao.CartaoDao
import com.example.zfinances.data.entity.CartaoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartaoRepository @Inject constructor(
    private val cartaoDao: CartaoDao
) {

    fun getAllCartoes(): Flow<List<CartaoEntity>> = cartaoDao.getAllCartoes()

    suspend fun getCartaoById(id: Long): CartaoEntity? = cartaoDao.getCartaoById(id)

    suspend fun insertCartao(cartao: CartaoEntity): Long = cartaoDao.insertCartao(cartao)

    suspend fun updateCartao(cartao: CartaoEntity) = cartaoDao.updateCartao(cartao)

    suspend fun deleteCartao(cartao: CartaoEntity) = cartaoDao.deleteCartao(cartao)

    suspend fun deleteCartaoById(id: Long) = cartaoDao.deleteCartaoById(id)
}
