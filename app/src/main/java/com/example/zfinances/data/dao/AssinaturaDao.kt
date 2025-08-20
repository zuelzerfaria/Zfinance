package com.example.zfinances.data.dao

import androidx.room.*
import com.example.zfinances.data.entity.AssinaturaEntity
import com.example.zfinances.data.entity.TipoRecorrencia
import kotlinx.coroutines.flow.Flow

@Dao
interface AssinaturaDao {

    @Query("SELECT * FROM assinaturas WHERE ativo = 1 ORDER BY nome ASC")
    fun getAssinaturasAtivas(): Flow<List<AssinaturaEntity>>

    @Query("SELECT * FROM assinaturas WHERE cartaoId = :cartaoId AND ativo = 1")
    fun getAssinaturasByCartao(cartaoId: Long): Flow<List<AssinaturaEntity>>

    @Query("SELECT * FROM assinaturas WHERE tipoRecorrencia = :tipo AND ativo = 1")
    fun getAssinaturasByTipo(tipo: TipoRecorrencia): Flow<List<AssinaturaEntity>>

    @Query("SELECT SUM(valor) FROM assinaturas WHERE tipoRecorrencia = 'MENSAL' AND ativo = 1")
    suspend fun getTotalAssinaturasMensais(): Double

    @Query("SELECT SUM(valor) FROM assinaturas WHERE tipoRecorrencia = 'ANUAL' AND ativo = 1")
    suspend fun getTotalAssinaturasAnuais(): Double

    @Insert
    suspend fun insertAssinatura(assinatura: AssinaturaEntity): Long

    @Update
    suspend fun updateAssinatura(assinatura: AssinaturaEntity)

    @Delete
    suspend fun deleteAssinatura(assinatura: AssinaturaEntity)

    @Query("UPDATE assinaturas SET ativo = 0 WHERE id = :id")
    suspend fun desativarAssinatura(id: Long)
}
