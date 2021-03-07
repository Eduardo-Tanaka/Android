package br.com.eduardotanaka.maximatech.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.eduardotanaka.maximatech.data.model.entity.Cliente
import br.com.eduardotanaka.maximatech.data.room.converter.Converters
import br.com.eduardotanaka.maximatech.data.room.dao.ClienteDao

@Database(
    version = 1,
    entities = [
        Cliente::class
    ],
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun clienteDao(): ClienteDao
}