package br.com.eduardotanaka.maximatech.ui.cliente.dados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.databinding.FragmentClienteBinding
import br.com.eduardotanaka.maximatech.ui.base.StatefulResource
import br.com.eduardotanaka.maximatech.util.DateTimeUtil.snackDateTimeFormatter
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

class DadosFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<DadosViewModelImpl> { factory }
    private var adapter: ContatoAdapter? = null

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private var fragmentClienteBinding: FragmentClienteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentClienteBinding.inflate(inflater, container, false)
        fragmentClienteBinding = binding

        viewModel.getCliente(30987)
        viewModel.cliente.observe(viewLifecycleOwner, {
            if (it.state == StatefulResource.State.SUCCESS && it.hasData()) {
                val cliente = it.resource?.data
                fragmentClienteBinding?.codigo?.text =
                    "${cliente?.codigo} - ${cliente?.razaoSocial}"
                fragmentClienteBinding?.empresa?.text = cliente?.nomeFantasia
                fragmentClienteBinding?.cpfNumero?.text = "id ${cliente?.id}"
                fragmentClienteBinding?.cnpjNumero?.text = cliente?.cnpj
                fragmentClienteBinding?.ramoDesc?.text = cliente?.ramoAtividade
                fragmentClienteBinding?.enderecoDesc?.text = cliente?.endereco

                adapter = ContatoAdapter(cliente?.contatos!!)
                fragmentClienteBinding?.rvContatos?.layoutManager = LinearLayoutManager(context)
                fragmentClienteBinding?.rvContatos?.adapter = adapter

                fragmentClienteBinding?.btnStatus?.setOnClickListener {
                    Snackbar.make(
                        binding.root,
                        snackDateTimeFormatter.format(LocalDateTime.now()) + " - Status " + cliente?.status,
                        Snackbar.LENGTH_LONG
                    )
                        .setAction("FECHAR") {
                            // Responds to click on the action
                        }
                        .setActionTextColor(context?.resources?.getColor(R.color.button_status)!!)
                        .show()
                }
            }
        })

        return binding.root
    }

    companion object {
        fun newInstance() = DadosFragment()
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        fragmentClienteBinding = null
        super.onDestroyView()
    }
}