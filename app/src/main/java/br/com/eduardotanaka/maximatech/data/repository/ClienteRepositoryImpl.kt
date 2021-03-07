package br.com.eduardotanaka.maximatech.data.repository

import android.content.SharedPreferences
import br.com.eduardotanaka.maximatech.constants.CacheKey
import br.com.eduardotanaka.maximatech.data.model.api.ClienteResponse
import br.com.eduardotanaka.maximatech.data.model.entity.Cliente
import br.com.eduardotanaka.maximatech.data.repository.base.BaseRepository
import br.com.eduardotanaka.maximatech.data.repository.base.Resource
import br.com.eduardotanaka.maximatech.data.repository.helpers.DataFetchHelper
import br.com.eduardotanaka.maximatech.data.room.AppDatabase
import br.com.eduardotanaka.maximatech.network.ClienteService
import retrofit2.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ClienteRepositoryImpl @Inject constructor(
    private val clienteService: ClienteService,
    private val appDatabase: AppDatabase,
    private val sharedPreferences: SharedPreferences
) : BaseRepository(), ClienteRepository {
    override suspend fun getCliente(id: Int): Resource<Cliente> {
        val dataFetchHelper = object : DataFetchHelper.LocalFirstUntilStale<Cliente>(
            ClienteRepositoryImpl::class.simpleName.toString(),
            sharedPreferences,
            CacheKey.CACHE_CLIENTE.toString(),
            "",
            TimeUnit.HOURS.toSeconds(24 * 30)
        ) {
            override suspend fun getDataFromLocal(): Cliente? {
                return appDatabase.clienteDao().getCliente(id)
            }

            override suspend fun getDataFromNetwork(): Response<out Any?> {
                return clienteService.getcliente()
            }

            override suspend fun convertApiResponseToData(response: Response<out Any?>): Cliente {
                return Cliente().reflectFrom(response.body() as ClienteResponse)
            }

            override suspend fun storeFreshDataToLocal(data: Cliente): Boolean {
                data.let {
                    appDatabase.clienteDao().insert(data)
                    return true
                }
            }
        }

        return dataFetchHelper.fetchDataIOAsync().await()
    }
}