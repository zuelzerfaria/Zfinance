package com.example.zfinances.domain.usecase

import com.example.zfinances.data.repository.PagamentoRepository
import com.example.zfinances.data.mapper.toEntity
import com.example.zfinances.domain.model.Pagamento
import javax.inject.Inject

class AdicionarPagamentoUseCase @Inject constructor(
    private val repository: PagamentoRepository
) {
    suspend operator fun invoke(pagamento: Pagamento): Long {
        return repository.insertPagamento(pagamento.toEntity())
    }
}
