package br.com.eduardotanaka.maximatech.data.repository

import br.com.eduardotanaka.maximatech.data.model.entity.RetrofitTeste
import br.com.eduardotanaka.maximatech.data.repository.base.Resource

interface RetrofitTesteRepository {

    suspend fun getAll(): Resource<List<RetrofitTeste>>
}