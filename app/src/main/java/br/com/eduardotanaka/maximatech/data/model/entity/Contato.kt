package br.com.eduardotanaka.maximatech.data.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.threeten.bp.LocalDate

@Parcelize
data class Contato(
    val nome: String,
    val telefone: String,
    val celular: String,
    val conjuge: String,
    val tipo: String,
    val time: String,
    val email: String,
    val dataNascimento: LocalDate,
    val dataNascimentoConjuge: LocalDate?
) : Parcelable