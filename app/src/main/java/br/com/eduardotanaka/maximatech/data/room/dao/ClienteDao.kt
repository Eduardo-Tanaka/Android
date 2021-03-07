package br.com.eduardotanaka.maximatech.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.eduardotanaka.maximatech.data.model.entity.Cliente
import br.com.eduardotanaka.maximatech.data.room.dao.base.BaseDao

@Dao
abstract class ClienteDao : BaseDao<Cliente>() {

    @Query("SELECT * FROM Cliente WHERE id = :id")
    abstract fun getCliente(id: Int): Cliente
}