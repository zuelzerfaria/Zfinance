package com.example.zfinances.di

import android.content.Context
import androidx.room.Room
import com.example.zfinances.data.database.ZfinancesDatabase
import com.example.zfinances.data.dao.CartaoDao
import com.example.zfinances.data.dao.PagamentoDao
import com.example.zfinances.data.dao.AssinaturaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideZfinancesDatabase(
        @ApplicationContext context: Context
    ): ZfinancesDatabase {
        return Room.databaseBuilder(
            context,
            ZfinancesDatabase::class.java,
            ZfinancesDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideCartaoDao(database: ZfinancesDatabase): CartaoDao {
        return database.cartaoDao()
    }

    @Provides
    fun providePagamentoDao(database: ZfinancesDatabase): PagamentoDao {
        return database.pagamentoDao()
    }

    @Provides
    fun provideAssinaturaDao(database: ZfinancesDatabase): AssinaturaDao {
        return database.assinaturaDao()
    }
}
