package com.example.zfinances.data.mapper

import com.example.zfinances.data.entity.CartaoEntity
import com.example.zfinances.data.entity.PagamentoEntity
import com.example.zfinances.data.entity.AssinaturaEntity
import com.example.zfinances.domain.model.Cartao
import com.example.zfinances.domain.model.Pagamento
import com.example.zfinances.domain.model.Assinatura

// Cartão mappers
fun CartaoEntity.toDomain(): Cartao {
    return Cartao(
        id = id,
        apelido = apelido,
        banco = banco,
        limite = limite,
        diaFechamento = diaFechamento,
        diaPagamento = diaPagamento
    )
}

fun Cartao.toEntity(): CartaoEntity {
    return CartaoEntity(
        id = id,
        apelido = apelido,
        banco = banco,
        limite = limite,
        diaFechamento = diaFechamento,
        diaPagamento = diaPagamento
    )
}

// Pagamento mappers
fun PagamentoEntity.toDomain(): Pagamento {
    return Pagamento(
        id = id,
        tipoCompra = tipoCompra,
        descricao = descricao,
        valor = valor,
        data = data,
        numeroParcelas = numeroParcelas,
        cartaoId = cartaoId
    )
}

fun Pagamento.toEntity(): PagamentoEntity {
    return PagamentoEntity(
        id = id,
        tipoCompra = tipoCompra,
        descricao = descricao,
        valor = valor,
        data = data,
        numeroParcelas = numeroParcelas,
        cartaoId = cartaoId
    )
}

// Assinatura mappers
fun AssinaturaEntity.toDomain(): Assinatura {
    return Assinatura(
        id = id,
        nome = nome,
        valor = valor,
        tipoRecorrencia = when (tipoRecorrencia) {
            com.example.zfinances.data.entity.TipoRecorrencia.MENSAL ->
                com.example.zfinances.domain.model.TipoRecorrencia.MENSAL
            com.example.zfinances.data.entity.TipoRecorrencia.ANUAL ->
                com.example.zfinances.domain.model.TipoRecorrencia.ANUAL
        },
        diaVencimento = diaVencimento,
        mesVencimento = mesVencimento,
        cartaoId = cartaoId,
        ativo = ativo
    )
}

fun Assinatura.toEntity(): AssinaturaEntity {
    return AssinaturaEntity(
        id = id,
        nome = nome,
        valor = valor,
        tipoRecorrencia = when (tipoRecorrencia) {
            com.example.zfinances.domain.model.TipoRecorrencia.MENSAL ->
                com.example.zfinances.data.entity.TipoRecorrencia.MENSAL
            com.example.zfinances.domain.model.TipoRecorrencia.ANUAL ->
                com.example.zfinances.data.entity.TipoRecorrencia.ANUAL
        },
        diaVencimento = diaVencimento,
        mesVencimento = mesVencimento,
        cartaoId = cartaoId,
        ativo = ativo
    )
}
