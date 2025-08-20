package com.example.zfinances.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zfinances.data.repository.PagamentoRepository
import com.example.zfinances.data.repository.CartaoRepository
import com.example.zfinances.data.mapper.toDomain
import com.example.zfinances.data.mapper.toEntity
import com.example.zfinances.domain.model.Pagamento
import com.example.zfinances.domain.model.Cartao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.time.LocalDate

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val pagamentoRepository: PagamentoRepository,
    private val cartaoRepository: CartaoRepository
) : ViewModel() {

    private val _pagamentos = MutableStateFlow<List<Pagamento>>(emptyList())
    val pagamentos: StateFlow<List<Pagamento>> = _pagamentos.asStateFlow()

    private val _cartoes = MutableStateFlow<List<Cartao>>(emptyList())
    val cartoes: StateFlow<List<Cartao>> = _cartoes.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadPagamentos()
        loadCartoes()
    }

    private fun loadPagamentos() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                pagamentoRepository.getAllPagamentos().collect { pagamentosEntity ->
                    _pagamentos.value = pagamentosEntity.map { it.toDomain() }
                }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun loadCartoes() {
        viewModelScope.launch {
            try {
                cartaoRepository.getAllCartoes().collect { cartoesEntity ->
                    _cartoes.value = cartoesEntity.map { it.toDomain() }
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun addPagamento(
        tipoCompra: String,
        descricao: String,
        valor: Double,
        data: LocalDate,
        numeroParcelas: Int,
        cartaoId: Long
    ) {
        viewModelScope.launch {
            try {
                val pagamento = Pagamento(
                    tipoCompra = tipoCompra,
                    descricao = descricao,
                    valor = valor,
                    data = data,
                    numeroParcelas = numeroParcelas,
                    cartaoId = cartaoId
                )
                pagamentoRepository.insertPagamento(pagamento.toEntity())
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun deletePagamento(pagamento: Pagamento) {
        viewModelScope.launch {
            try {
                pagamentoRepository.deletePagamento(pagamento.toEntity())
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun getTotalGasto(): Double {
        return _pagamentos.value.sumOf { it.valor }
    }

    fun clearError() {
        _error.value = null
    }
}
