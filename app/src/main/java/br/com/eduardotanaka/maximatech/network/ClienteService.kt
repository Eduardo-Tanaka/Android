package br.com.eduardotanaka.maximatech.network

import br.com.eduardotanaka.maximatech.data.model.api.ClienteResponse
import retrofit2.Response
import retrofit2.http.GET

// https://private-anon-e8478c446c-maximatech.apiary-mock.com/android/cliente
interface ClienteService {

    @GET("/android/cliente")
    suspend fun getcliente(): Response<ClienteResponse>

}