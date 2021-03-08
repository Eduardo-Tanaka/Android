package br.com.eduardotanaka.maximatech.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.eduardotanaka.maximatech.data.model.entity.Pedido
import br.com.eduardotanaka.maximatech.data.room.dao.base.BaseDao

@Dao
abstract class PedidoDao : BaseDao<Pedido>() {

    @Query("SELECT * FROM Pedido")
    abstract fun getPedidos(): List<Pedido>
}