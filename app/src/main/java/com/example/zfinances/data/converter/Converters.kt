package com.example.zfinances.data.converter

import androidx.room.TypeConverter
import com.example.zfinances.data.entity.TipoRecorrencia
import java.time.LocalDate

class Converters {

    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        return dateString?.let { LocalDate.parse(it) }
    }

    @TypeConverter
    fun fromTipoRecorrencia(tipo: TipoRecorrencia): String {
        return tipo.name
    }

    @TypeConverter
    fun toTipoRecorrencia(tipoString: String): TipoRecorrencia {
        return TipoRecorrencia.valueOf(tipoString)
    }
}
