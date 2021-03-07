package br.com.eduardotanaka.maximatech.ui.cliente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.eduardotanaka.maximatech.R
import dagger.android.support.DaggerFragment

class DadosFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cliente, container, false)
    }

    companion object {
        fun newInstance() = DadosFragment()
    }

}