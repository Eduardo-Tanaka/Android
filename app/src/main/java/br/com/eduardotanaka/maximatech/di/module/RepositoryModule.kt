package br.com.eduardotanaka.maximatech.di.module

import br.com.eduardotanaka.maximatech.data.repository.ClienteRepository
import br.com.eduardotanaka.maximatech.data.repository.ClienteRepositoryImpl
import br.com.eduardotanaka.maximatech.data.repository.PedidoRepository
import br.com.eduardotanaka.maximatech.data.repository.PedidoRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Classes repository colocar aqui
 */
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindClienteRepository(clienteRepository: ClienteRepositoryImpl): ClienteRepository

    @Binds
    @Singleton
    abstract fun bindPedidoRepository(pedidoRepository: PedidoRepositoryImpl): PedidoRepository
}