package br.com.eduardotanaka.maximatech.ui.cliente.pedidos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.data.model.entity.Pedido
import br.com.eduardotanaka.maximatech.data.repository.PedidoRepository
import br.com.eduardotanaka.maximatech.ui.base.BaseViewModel
import br.com.eduardotanaka.maximatech.ui.base.StatefulResource
import javax.inject.Inject

class PedidoViewModelImpl @Inject constructor(
    private val pedidoRepository: PedidoRepository
) : BaseViewModel(), PedidoViewModel {

    private val mutablePedidos: MutableLiveData<StatefulResource<List<Pedido>>> = MutableLiveData()
    override val pedidos: LiveData<StatefulResource<List<Pedido>>> = mutablePedidos

    override fun getPedidos() {
        launch {
            mutablePedidos.value = StatefulResource.with(StatefulResource.State.LOADING)
            val resource = pedidoRepository.getPedidos()
            when {
                resource.hasData() -> {
                    //return the value
                    mutablePedidos.value = StatefulResource.success(resource)
                }
                resource.isNetworkIssue() -> {
                    mutablePedidos.value = StatefulResource<List<Pedido>>()
                        .apply {
                            setMessage(R.string.no_network_connection)
                            setState(StatefulResource.State.ERROR_NETWORK)
                        }
                }
                resource.isApiIssue() -> //TODO 4xx isn't necessarily a service error, expand this to sniff http code before saying service error
                    if (resource.response?.code() == 404) {
                        mutablePedidos.value = StatefulResource<List<Pedido>>()
                            .apply {
                                setState(StatefulResource.State.ERROR_API)
                                setMessage(R.string.not_found)
                            }
                    } else {
                        mutablePedidos.value = StatefulResource<List<Pedido>>()
                            .apply {
                                setState(StatefulResource.State.ERROR_API)
                                setMessage(R.string.service_error)
                            }
                    }
                else -> mutablePedidos.value = StatefulResource<List<Pedido>>()
                    .apply {
                        setState(StatefulResource.State.SUCCESS)
                        setMessage(R.string.not_found)
                    }
            }
        }
    }
}
