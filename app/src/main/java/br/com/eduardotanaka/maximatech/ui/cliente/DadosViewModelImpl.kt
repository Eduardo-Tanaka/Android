package br.com.eduardotanaka.maximatech.ui.cliente

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.data.model.entity.Cliente
import br.com.eduardotanaka.maximatech.data.repository.ClienteRepository
import br.com.eduardotanaka.maximatech.ui.base.BaseViewModel
import br.com.eduardotanaka.maximatech.ui.base.StatefulResource
import javax.inject.Inject

class DadosViewModelImpl @Inject constructor(
    private val clienteRepository: ClienteRepository
) : BaseViewModel(), DadosViewModel {

    private val mutableCliente: MutableLiveData<StatefulResource<Cliente>> = MutableLiveData()
    override val cliente: LiveData<StatefulResource<Cliente>> = mutableCliente

    override fun getCliente(id: Int) {
        launch {
            mutableCliente.value = StatefulResource.with(StatefulResource.State.LOADING)
            val resource = clienteRepository.getCliente(id)
            when {
                resource.hasData() -> {
                    //return the value
                    mutableCliente.value = StatefulResource.success(resource)
                }
                resource.isNetworkIssue() -> {
                    mutableCliente.value = StatefulResource<Cliente>()
                        .apply {
                            setMessage(R.string.no_network_connection)
                            setState(StatefulResource.State.ERROR_NETWORK)
                        }
                }
                resource.isApiIssue() -> //TODO 4xx isn't necessarily a service error, expand this to sniff http code before saying service error
                    if (resource.response?.code() == 404) {
                        mutableCliente.value = StatefulResource<Cliente>()
                            .apply {
                                setState(StatefulResource.State.ERROR_API)
                                setMessage(R.string.not_found)
                            }
                    } else {
                        mutableCliente.value = StatefulResource<Cliente>()
                            .apply {
                                setState(StatefulResource.State.ERROR_API)
                                setMessage(R.string.service_error)
                            }
                    }
                else -> mutableCliente.value = StatefulResource<Cliente>()
                    .apply {
                        setState(StatefulResource.State.SUCCESS)
                        setMessage(R.string.not_found)
                    }
            }
        }
    }
}