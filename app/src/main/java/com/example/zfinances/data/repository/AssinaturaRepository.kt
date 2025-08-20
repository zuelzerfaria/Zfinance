package com.example.zfinances.data.repository

import com.example.zfinances.data.dao.AssinaturaDao
import com.example.zfinances.data.entity.AssinaturaEntity
import com.example.zfinances.data.entity.TipoRecorrencia
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssinaturaRepository @Inject constructor(
    private val assinaturaDao: AssinaturaDao
) {

    fun getAssinaturasAtivas(): Flow<List<AssinaturaEntity>> =
        assinaturaDao.getAssinaturasAtivas()

    fun getAssinaturasByCartao(cartaoId: Long): Flow<List<AssinaturaEntity>> =
        assinaturaDao.getAssinaturasByCartao(cartaoId)

    fun getAssinaturasByTipo(tipo: TipoRecorrencia): Flow<List<AssinaturaEntity>> =
        assinaturaDao.getAssinaturasByTipo(tipo)

    suspend fun getTotalAssinaturasMensais(): Double =
        assinaturaDao.getTotalAssinaturasMensais()

    suspend fun getTotalAssinaturasAnuais(): Double =
        assinaturaDao.getTotalAssinaturasAnuais()

    suspend fun insertAssinatura(assinatura: AssinaturaEntity): Long =
        assinaturaDao.insertAssinatura(assinatura)

    suspend fun updateAssinatura(assinatura: AssinaturaEntity) =
        assinaturaDao.updateAssinatura(assinatura)

    suspend fun deleteAssinatura(assinatura: AssinaturaEntity) =
        assinaturaDao.deleteAssinatura(assinatura)

    suspend fun desativarAssinatura(id: Long) =
        assinaturaDao.desativarAssinatura(id)
}
