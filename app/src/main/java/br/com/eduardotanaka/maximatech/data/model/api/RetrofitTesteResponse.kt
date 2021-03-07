package br.com.eduardotanaka.maximatech.data.model.api

import br.com.eduardotanaka.maximatech.data.model.api.base.ApiResponseObject

data class RetrofitTesteResponse(
    val retrofitTesteModelList: List<RetrofitTesteModel>
) : ApiResponseObject