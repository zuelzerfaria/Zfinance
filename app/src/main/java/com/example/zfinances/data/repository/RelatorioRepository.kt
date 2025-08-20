package com.example.zfinances.data.repository

import com.example.zfinances.data.dao.PagamentoDao
import com.example.zfinances.data.dao.AssinaturaDao
import com.example.zfinances.data.dao.CartaoDao
import com.example.zfinances.data.entity.TipoRecorrencia
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import java.time.LocalDate
import java.time.YearMonth
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RelatorioRepository @Inject constructor(
    private val pagamentoDao: PagamentoDao,
    private val assinaturaDao: AssinaturaDao,
    private val cartaoDao: CartaoDao
) {

    // Relatórios de gastos por período
    suspend fun getGastoTotalMes(ano: Int, mes: Int): Double {
        val primeiroDia = LocalDate.of(ano, mes, 1)
        val ultimoDia = YearMonth.of(ano, mes).atEndOfMonth()
        return pagamentoDao.getTotalGastoPorPeriodo(primeiroDia, ultimoDia)
    }

    suspend fun getGastoTotalAno(ano: Int): Double {
        val primeirodia = LocalDate.of(ano, 1, 1)
        val ultimodia = LocalDate.of(ano, 12, 31)
        return pagamentoDao.getTotalGastoPorPeriodo(primeirodia, ultimodia)
    }

    // Projeção de fatura mensal com assinaturas
    suspend fun getProjecaoFaturaMensal(): Double {
        val totalAssinaturasMensais = assinaturaDao.getTotalAssinaturasMensais()
        val totalAssinaturasAnuais = assinaturaDao.getTotalAssinaturasAnuais()
        val assinaturasAnuaisMensalizadas = totalAssinaturasAnuais / 12

        return totalAssinaturasMensais + assinaturasAnuaisMensalizadas
    }

    // Média de gastos por tipo de compra
    suspend fun getMediaGastosPorTipo(): Map<String, Double> {
        val tipos = pagamentoDao.getTiposCompra()
        val mediaPorTipo = mutableMapOf<String, Double>()

        // Como getTiposCompra retorna Flow, precisamos coletar os dados
        tipos.collect { listaTipos ->
            listaTipos.forEach { tipo ->
                mediaPorTipo[tipo] = pagamentoDao.getMediaGastoPorTipo(tipo)
            }
        }

        return mediaPorTipo
    }

    // Gastos por cartão em um período
    fun getGastosPorCartaoPeriodo(dataInicio: LocalDate, dataFim: LocalDate): Flow<Map<String, Double>> {
        return combine(
            cartaoDao.getAllCartoes(),
            pagamentoDao.getPagamentosByPeriodo(dataInicio, dataFim)
        ) { cartoes, pagamentos ->
            val gastosPorCartao = mutableMapOf<String, Double>()

            cartoes.forEach { cartao ->
                val gastosCartao = pagamentos
                    .filter { it.cartaoId == cartao.id }
                    .sumOf { it.valor }
                gastosPorCartao[cartao.apelido] = gastosCartao
            }

            gastosPorCartao
        }
    }

    // Análise de utilização de limite por cartão
    fun getUtilizacaoLimiteCartoes(): Flow<Map<String, Pair<Double, Double>>> {
        return combine(
            cartaoDao.getAllCartoes(),
            pagamentoDao.getAllPagamentos()
        ) { cartoes, pagamentos ->
            val utilizacaoPorCartao = mutableMapOf<String, Pair<Double, Double>>()

            cartoes.forEach { cartao ->
                val gastoTotal = pagamentos
                    .filter { it.cartaoId == cartao.id }
                    .sumOf { it.valor }

                utilizacaoPorCartao[cartao.apelido] = Pair(gastoTotal, cartao.limite)
            }

            utilizacaoPorCartao
        }
    }
}
