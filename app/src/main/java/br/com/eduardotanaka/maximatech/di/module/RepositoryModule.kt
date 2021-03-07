package br.com.eduardotanaka.maximatech.di.module

import br.com.eduardotanaka.maximatech.data.repository.RetrofitTesteRepository
import br.com.eduardotanaka.maximatech.data.repository.RetrofitTesteRepositoryImpl
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
    abstract fun bindRetrofitTesteRepository(retrofitTesteRepository: RetrofitTesteRepositoryImpl): RetrofitTesteRepository

}