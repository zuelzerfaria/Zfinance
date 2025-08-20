package com.example.zfinances.data.repository

import com.example.zfinances.data.dao.PagamentoDao
import com.example.zfinances.data.entity.PagamentoEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PagamentoRepository @Inject constructor(
    private val pagamentoDao: PagamentoDao
) {

    fun getAllPagamentos(): Flow<List<PagamentoEntity>> = pagamentoDao.getAllPagamentos()

    fun getPagamentosByCartao(cartaoId: Long): Flow<List<PagamentoEntity>> =
        pagamentoDao.getPagamentosByCartao(cartaoId)

    fun getPagamentosByPeriodo(dataInicio: LocalDate, dataFim: LocalDate): Flow<List<PagamentoEntity>> =
        pagamentoDao.getPagamentosByPeriodo(dataInicio, dataFim)

    fun getPagamentosByTipo(tipo: String): Flow<List<PagamentoEntity>> =
        pagamentoDao.getPagamentosByTipo(tipo)

    fun getTiposCompra(): Flow<List<String>> = pagamentoDao.getTiposCompra()

    suspend fun getMediaGastoPorTipo(tipo: String): Double =
        pagamentoDao.getMediaGastoPorTipo(tipo)

    suspend fun getTotalGastoPorPeriodo(dataInicio: LocalDate, dataFim: LocalDate): Double =
        pagamentoDao.getTotalGastoPorPeriodo(dataInicio, dataFim)

    suspend fun insertPagamento(pagamento: PagamentoEntity): Long =
        pagamentoDao.insertPagamento(pagamento)

    suspend fun updatePagamento(pagamento: PagamentoEntity) =
        pagamentoDao.updatePagamento(pagamento)

    suspend fun deletePagamento(pagamento: PagamentoEntity) =
        pagamentoDao.deletePagamento(pagamento)
}
