package br.com.eduardotanaka.maximatech.ui

import androidx.lifecycle.LiveData
import br.com.eduardotanaka.maximatech.data.model.entity.RetrofitTeste
import br.com.eduardotanaka.maximatech.ui.base.StatefulResource

interface MainActivityViewModel {

    val retrofitTesteList: LiveData<StatefulResource<List<RetrofitTeste>>>
    fun getAll()
}