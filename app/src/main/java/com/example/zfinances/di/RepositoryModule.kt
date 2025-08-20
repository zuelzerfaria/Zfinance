package com.example.zfinances.di

import com.example.zfinances.data.repository.CreditCardRepositoryImpl
import com.example.zfinances.domain.repository.CreditCardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCreditCardRepository(
        creditCardRepositoryImpl: CreditCardRepositoryImpl
    ): CreditCardRepository
}
