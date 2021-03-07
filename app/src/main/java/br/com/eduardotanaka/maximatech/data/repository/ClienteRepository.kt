package br.com.eduardotanaka.maximatech.data.repository

import br.com.eduardotanaka.maximatech.data.model.entity.Cliente
import br.com.eduardotanaka.maximatech.data.repository.base.Resource

interface ClienteRepository {

    suspend fun getCliente(id: Int): Resource<Cliente>

}