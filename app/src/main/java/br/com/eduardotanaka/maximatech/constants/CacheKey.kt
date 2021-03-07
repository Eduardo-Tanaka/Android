package br.com.eduardotanaka.maximatech.constants

enum class CacheKey {

    CACHE_NAME;

    override fun toString(): String {
        return name
    }
}