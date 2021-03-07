package br.com.eduardotanaka.maximatech.di.module

import br.com.eduardotanaka.maximatech.ui.MainActivity
import br.com.eduardotanaka.maximatech.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Colocar as activities aqui e caso necessário importar os modules
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

}