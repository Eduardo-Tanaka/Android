package br.com.eduardotanaka.maximatech.data.repository

import android.content.SharedPreferences
import br.com.eduardotanaka.maximatech.constants.CacheKey
import br.com.eduardotanaka.maximatech.data.model.api.PedidoResponse
import br.com.eduardotanaka.maximatech.data.model.entity.Pedido
import br.com.eduardotanaka.maximatech.data.repository.base.BaseRepository
import br.com.eduardotanaka.maximatech.data.repository.base.Resource
import br.com.eduardotanaka.maximatech.data.repository.helpers.DataFetchHelper
import br.com.eduardotanaka.maximatech.data.room.AppDatabase
import br.com.eduardotanaka.maximatech.network.PedidoService
import retrofit2.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PedidoRepositoryImpl @Inject constructor(
    private val pedidoService: PedidoService,
    private val appDatabase: AppDatabase,
    private val sharedPreferences: SharedPreferences
) : BaseRepository(), PedidoRepository {
    override suspend fun getPedidos(): Resource<List<Pedido>> {
        val dataFetchHelper = object : DataFetchHelper.LocalFirstUntilStale<List<Pedido>>(
            PedidoRepositoryImpl::class.simpleName.toString(),
            sharedPreferences,
            CacheKey.CACHE_PEDIDO.toString(),
            "",
            TimeUnit.HOURS.toSeconds(24 * 30)
        ) {
            override suspend fun getDataFromLocal(): List<Pedido>? {
                return appDatabase.pedidoDao().getPedidos()
            }

            override suspend fun getDataFromNetwork(): Response<out Any?> {
                return pedidoService.getPedidos()
            }

            override suspend fun convertApiResponseToData(response: Response<out Any?>): List<Pedido> {
                return Pedido().reflectFrom(response.body() as PedidoResponse)
            }

            override suspend fun storeFreshDataToLocal(data: List<Pedido>): Boolean {
                data.let {
                    appDatabase.pedidoDao().insert(data)
                    return true
                }
            }
        }

        return dataFetchHelper.fetchDataIOAsync().await()
    }
}