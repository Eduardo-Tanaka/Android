package br.com.eduardotanaka.maximatech.ui.cliente

import androidx.lifecycle.LiveData
import br.com.eduardotanaka.maximatech.data.model.entity.Cliente
import br.com.eduardotanaka.maximatech.ui.base.StatefulResource

interface DadosViewModel {

    val cliente: LiveData<StatefulResource<Cliente>>
    fun getCliente(id: Int)
}