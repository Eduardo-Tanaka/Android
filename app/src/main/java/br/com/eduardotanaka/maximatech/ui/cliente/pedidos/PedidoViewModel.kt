package br.com.eduardotanaka.maximatech.ui.cliente.pedidos

import androidx.lifecycle.LiveData
import br.com.eduardotanaka.maximatech.data.model.entity.Pedido
import br.com.eduardotanaka.maximatech.ui.base.StatefulResource

interface PedidoViewModel {

    val pedidos: LiveData<StatefulResource<List<Pedido>>>
    fun getPedidos()
}