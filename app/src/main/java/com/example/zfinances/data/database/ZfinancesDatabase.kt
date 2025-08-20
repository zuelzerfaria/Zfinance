package com.example.zfinances.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.zfinances.data.converter.Converters
import com.example.zfinances.data.dao.CartaoDao
import com.example.zfinances.data.dao.PagamentoDao
import com.example.zfinances.data.dao.AssinaturaDao
import com.example.zfinances.data.entity.CartaoEntity
import com.example.zfinances.data.entity.PagamentoEntity
import com.example.zfinances.data.entity.AssinaturaEntity

@Database(
    entities = [
        CartaoEntity::class,
        PagamentoEntity::class,
        AssinaturaEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ZfinancesDatabase : RoomDatabase() {

    abstract fun cartaoDao(): CartaoDao
    abstract fun pagamentoDao(): PagamentoDao
    abstract fun assinaturaDao(): AssinaturaDao

    companion object {
        const val DATABASE_NAME = "zfinances_database"
    }
}
