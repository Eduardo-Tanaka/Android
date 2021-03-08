package br.com.eduardotanaka.maximatech.data.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.eduardotanaka.maximatech.data.model.api.PedidoResponse
import br.com.eduardotanaka.maximatech.data.model.entity.base.ReflectsApiResponse
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Pedido(
    @PrimaryKey
    var numeroPedRca: Int? = null,
    var numeroPedErp: String? = null,
    var codigoCliente: String? = null,
    var nomeCliente: String? = null,
    var data: String? = null,
    var status: String? = null,
    var critica: String? = null,
    var tipo: String? = null,
    var legendas: List<String>? = null
) : ReflectsApiResponse<List<Pedido>, PedidoResponse>, Parcelable {
    override fun reflectFrom(apiResponse: PedidoResponse): List<Pedido> {
        apiResponse.let { result ->
            val list = ArrayList<Pedido>()
            result.pedidos.map {
                list.add(
                    Pedido(
                        it.numeroPedRca,
                        it.numeroPedErp,
                        it.codigoCliente,
                        it.nomeCliente,
                        it.data,
                        it.status,
                        it.critica,
                        it.tipo,
                        it.legendas
                    )
                )
            }

            return list
        }
    }
}