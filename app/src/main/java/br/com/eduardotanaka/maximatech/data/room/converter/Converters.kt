package br.com.eduardotanaka.maximatech.data.room.converter

import androidx.room.TypeConverter
import br.com.eduardotanaka.maximatech.data.model.entity.Contato
import br.com.eduardotanaka.maximatech.util.DateTimeUtil.defaultFormatter
import br.com.eduardotanaka.maximatech.util.DateTimeUtil.localDateTimeFormatter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

class Converters {

    @TypeConverter
    fun fromOffsetDateTime(date: LocalDate?): String? {
        return date?.format(defaultFormatter)
    }

    @TypeConverter
    fun toOffsetDateTime(value: String?): LocalDate? {
        return value?.let {
            return defaultFormatter.parse(value, LocalDate::from)
        }
    }

    @TypeConverter
    fun fromOffsetLocalDateTime(date: LocalDateTime?): String? {
        return date?.format(localDateTimeFormatter)
    }

    @TypeConverter
    fun toOffsetLocalDateTime(value: String?): LocalDateTime? {
        return value?.let {
            return localDateTimeFormatter.parse(value, LocalDateTime::from)
        }
    }

    @TypeConverter
    fun fromListOfContatos(offers: List<Contato>?): String? {
        return offers?.let {
            return Gson().toJson(it, object : TypeToken<List<Contato>>() {}.type)
        }
    }

    @TypeConverter
    fun toListOfContatos(offersListStringBuffer: String?): List<Contato>? {
        return Gson().fromJson(offersListStringBuffer, object : TypeToken<List<Contato>>() {}.type)
    }

    @TypeConverter
    fun fromListOfString(offers: List<String>?): String? {
        return offers?.let {
            return Gson().toJson(it, object : TypeToken<List<String>>() {}.type)
        }
    }

    @TypeConverter
    fun toListOfString(offersListStringBuffer: String?): List<String>? {
        return Gson().fromJson(offersListStringBuffer, object : TypeToken<List<String>>() {}.type)
    }
}