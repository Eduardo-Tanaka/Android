package br.com.eduardotanaka.maximatech.di.module

import br.com.eduardotanaka.maximatech.ui.cliente.AlvaraFragment
import br.com.eduardotanaka.maximatech.ui.cliente.dados.DadosFragment
import br.com.eduardotanaka.maximatech.ui.cliente.pedidos.PedidoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeClienteFragment(): DadosFragment

    @ContributesAndroidInjector
    internal abstract fun contributePedidoFragment(): PedidoFragment

    @ContributesAndroidInjector
    internal abstract fun contributeAlvaraFragment(): AlvaraFragment
}