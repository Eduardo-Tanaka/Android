package br.com.eduardotanaka.maximatech.ui.cliente

import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.databinding.ActivityClienteBinding
import br.com.eduardotanaka.maximatech.ui.base.BaseActivity
import br.com.eduardotanaka.maximatech.ui.cliente.dados.DadosFragment
import br.com.eduardotanaka.maximatech.ui.cliente.pedidos.PedidoFragment

class ClienteActivity : BaseActivity() {

    private lateinit var binding: ActivityClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val fragmentDados: Fragment = DadosFragment.newInstance()
        var fragmentPedidos: Fragment? = null
        var fragmentAlvaras: Fragment? = null

        val fm = supportFragmentManager
        var active = fragmentDados

        fm.beginTransaction().add(R.id.fragment_container_view, fragmentDados, "1").commit()
        supportActionBar?.title = "Dados do cliente"

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_menu_cliente -> {
                    supportActionBar?.title = "Dados do cliente"
                    fm.beginTransaction().hide(active).show(fragmentDados).commit();
                    active = fragmentDados
                    true
                }
                R.id.bottom_menu_pedidos -> {
                    supportActionBar?.title = "Hist. de pedidos"
                    if (fragmentPedidos == null) {
                        fragmentPedidos = PedidoFragment.newInstance()
                        fm.beginTransaction()
                            .add(R.id.fragment_container_view, fragmentPedidos!!, "2").commit();
                    }

                    fm.beginTransaction().hide(active).show(fragmentPedidos!!).commit();

                    active = fragmentPedidos!!
                    true
                }
                R.id.bottom_menu_alvara -> {
                    supportActionBar?.title = "Alvarás"
                    if (fragmentAlvaras == null) {
                        fragmentAlvaras = AlvaraFragment.newInstance()
                        fm.beginTransaction()
                            .add(R.id.fragment_container_view, fragmentAlvaras!!, "3").commit();
                    }

                    fm.beginTransaction().hide(active).show(fragmentAlvaras!!).commit();

                    active = fragmentAlvaras!!
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
}