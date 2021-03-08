package br.com.eduardotanaka.maximatech.constants

enum class CacheKey {

    CACHE_CLIENTE,
    CACHE_PEDIDO;

    override fun toString(): String {
        return name
    }
}