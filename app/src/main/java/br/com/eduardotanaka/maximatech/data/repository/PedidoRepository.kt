package br.com.eduardotanaka.maximatech.data.repository

import br.com.eduardotanaka.maximatech.data.model.entity.Pedido
import br.com.eduardotanaka.maximatech.data.repository.base.Resource

interface PedidoRepository {

    suspend fun getPedidos(): Resource<List<Pedido>>

}