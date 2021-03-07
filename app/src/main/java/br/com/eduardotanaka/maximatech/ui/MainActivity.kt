package br.com.eduardotanaka.maximatech.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.widget.Toast
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.databinding.ActivityMainBinding
import br.com.eduardotanaka.maximatech.ui.base.BaseActivity
import br.com.eduardotanaka.maximatech.ui.cliente.ClienteActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val list = listOf(
            Card("ic_maxima_pessoas", "Cliente"),
            Card("ic_maxima_pedido", "Pedidos"),
            Card("ic_maxima_resumo_vendas", "Resumo de Vendas"),
            Card("ic_maxima_ferramentas", "Ferramentas")
        )
        val adapter = MainActivityAdapter(list, this)
        binding.rvCards.adapter = adapter
        adapter.onItemSelectedListener = object :
            MainActivityAdapter.OnItemSelectedListener {
            override fun onCardClicked(
                card: Card
            ) {
                when (card.title) {
                    "Cliente" -> {
                        val intent = Intent(this@MainActivity, ClienteActivity::class.java)
                        startActivity(intent)
                    }
                    else -> Toast.makeText(this@MainActivity, "Funcionalidade não implementada", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val pInfo = this.packageManager.getPackageInfo(this.packageName, 0)
        binding.version.text = pInfo.versionName

        // https://developer.android.com/training/monitoring-device-state/connectivity-status-type
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected) {
            binding.imageNetwork.setImageDrawable(getDrawable(R.drawable.ic_maxima_nuvem_conectado))
        } else {
            binding.imageNetwork.setImageDrawable(getDrawable(R.drawable.ic_maxima_nuvem_desconectado))
        }
    }
}