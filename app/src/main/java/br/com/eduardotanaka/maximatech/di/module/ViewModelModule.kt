package br.com.eduardotanaka.maximatech.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.eduardotanaka.maximatech.di.ViewModelFactory
import br.com.eduardotanaka.maximatech.di.ViewModelKey
import br.com.eduardotanaka.maximatech.ui.cliente.dados.DadosViewModelImpl
import br.com.eduardotanaka.maximatech.ui.cliente.pedidos.PedidoViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

/**
 * Usado para injetar dependencias nos ViewModels
 */
@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DadosViewModelImpl::class)
    abstract fun bindDadosActivityViewModel(dadosViewModelImpl: DadosViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PedidoViewModelImpl::class)
    abstract fun bindPedidosActivityViewModel(pedidoViewModelImpl: PedidoViewModelImpl): ViewModel

}