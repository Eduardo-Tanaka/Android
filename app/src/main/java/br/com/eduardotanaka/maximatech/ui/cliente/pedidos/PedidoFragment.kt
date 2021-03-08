package br.com.eduardotanaka.maximatech.ui.cliente.pedidos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.databinding.FragmentPedidoBinding
import br.com.eduardotanaka.maximatech.ui.base.StatefulResource
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PedidoFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<PedidoViewModelImpl> { factory }
    private var adapter: PedidoAdapter? = null

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private var fragmentPedidoBinding: FragmentPedidoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPedidoBinding.inflate(inflater, container, false)
        fragmentPedidoBinding = binding

        viewModel.getPedidos()
        viewModel.pedidos.observe(viewLifecycleOwner, {
            if (it.state == StatefulResource.State.SUCCESS && it.hasData()) {
                val pedidos = it.resource?.data

                adapter = PedidoAdapter(pedidos!!)
                fragmentPedidoBinding?.rvPedidos?.layoutManager = LinearLayoutManager(context)
                fragmentPedidoBinding?.rvPedidos?.adapter = adapter
            }
        })

        return binding.root
    }

    companion object {
        fun newInstance() = PedidoFragment()
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        fragmentPedidoBinding = null
        super.onDestroyView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search -> {
                true
            }
            R.id.legenda -> {
                true
            }
            else -> false
        }
    }
}