package br.com.eduardotanaka.maximatech.ui.cliente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.databinding.FragmentClienteBinding
import br.com.eduardotanaka.maximatech.util.DateTimeUtil.snackDateTimeFormatter
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import org.threeten.bp.LocalDateTime

class DadosFragment : DaggerFragment() {

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private var fragmentClienteBinding: FragmentClienteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentClienteBinding.inflate(inflater, container, false)
        fragmentClienteBinding = binding

        fragmentClienteBinding!!.btnStatus.setOnClickListener {
            Snackbar.make(
                binding.root,
                snackDateTimeFormatter.format(LocalDateTime.now()) + " - Status ativo",
                Snackbar.LENGTH_LONG
            )
                .setAction("FECHAR") {
                    // Responds to click on the action
                }
                .setActionTextColor(context?.resources?.getColor(R.color.button_status)!!)
                .show()
        }

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