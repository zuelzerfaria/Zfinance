package com.example.zfinances.data.dao

import androidx.room.*
import com.example.zfinances.data.entity.PagamentoEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface PagamentoDao {

    @Query("SELECT * FROM pagamentos ORDER BY data DESC")
    fun getAllPagamentos(): Flow<List<PagamentoEntity>>

    @Query("SELECT * FROM pagamentos WHERE cartaoId = :cartaoId ORDER BY data DESC")
    fun getPagamentosByCartao(cartaoId: Long): Flow<List<PagamentoEntity>>

    @Query("SELECT * FROM pagamentos WHERE data BETWEEN :dataInicio AND :dataFim ORDER BY data DESC")
    fun getPagamentosByPeriodo(dataInicio: LocalDate, dataFim: LocalDate): Flow<List<PagamentoEntity>>

    @Query("SELECT * FROM pagamentos WHERE tipoCompra = :tipo ORDER BY data DESC")
    fun getPagamentosByTipo(tipo: String): Flow<List<PagamentoEntity>>

    @Query("SELECT DISTINCT tipoCompra FROM pagamentos ORDER BY tipoCompra ASC")
    fun getTiposCompra(): Flow<List<String>>

    @Query("SELECT AVG(valor) FROM pagamentos WHERE tipoCompra = :tipo")
    suspend fun getMediaGastoPorTipo(tipo: String): Double

    @Query("SELECT SUM(valor) FROM pagamentos WHERE data BETWEEN :dataInicio AND :dataFim")
    suspend fun getTotalGastoPorPeriodo(dataInicio: LocalDate, dataFim: LocalDate): Double

    @Insert
    suspend fun insertPagamento(pagamento: PagamentoEntity): Long

    @Update
    suspend fun updatePagamento(pagamento: PagamentoEntity)

    @Delete
    suspend fun deletePagamento(pagamento: PagamentoEntity)
}
