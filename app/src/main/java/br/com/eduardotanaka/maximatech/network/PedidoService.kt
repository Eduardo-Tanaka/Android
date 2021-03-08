package br.com.eduardotanaka.maximatech.network

import br.com.eduardotanaka.maximatech.data.model.api.PedidoResponse
import retrofit2.Response
import retrofit2.http.GET

// https://private-anon-e8478c446c-maximatech.apiary-mock.com/android/pedido
interface PedidoService {

    @GET("/android/pedido")
    suspend fun getPedidos(): Response<PedidoResponse>

}