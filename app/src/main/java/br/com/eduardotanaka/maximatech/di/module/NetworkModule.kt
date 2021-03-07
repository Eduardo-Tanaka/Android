package br.com.eduardotanaka.maximatech.di.module

import br.com.eduardotanaka.maximatech.BuildConfig
import br.com.eduardotanaka.maximatech.network.ClienteService
import br.com.eduardotanaka.maximatech.network.HttpRequestInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * colocar as interfaces de chamadas do retrofit aqui
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpRequestInterceptor(): HttpRequestInterceptor = HttpRequestInterceptor()

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.NONE else HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpRequestInterceptor: HttpRequestInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpRequestInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        val gson = GsonBuilder()
        return gson.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.ApiUrl)
            .addConverterFactory(
                GsonConverterFactory
                    .create(gson)
            )
        return retrofit.build()
    }

    @Singleton
    @Provides
    fun provideClienteService(retrofit: Retrofit): ClienteService =
        retrofit.create(ClienteService::class.java)
}
