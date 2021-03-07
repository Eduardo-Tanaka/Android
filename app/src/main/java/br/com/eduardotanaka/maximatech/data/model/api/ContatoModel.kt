package br.com.eduardotanaka.maximatech.data.model.api

import br.com.eduardotanaka.maximatech.data.model.api.base.ApiResponseObject
import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDate

/*
{
    "nome": "Gean Delon",
    "telefone": "3333-3365",
    "celular": "62988889888",
    "conjuge": "",
    "tipo": "Sócio",
    "time": "Flamengo",
    "e_mail": "gean.paiva@maximasistemas.com.br",
    "data_nascimento": "1992-12-11",
    "dataNascimentoConjuge": null
}
 */
data class ContatoModel(
    val nome: String,
    val telefone: String,
    val celular: String,
    val conjuge: String,
    val tipo: String,
    val time: String,
    @SerializedName("e_mail")
    val email: String,
    @SerializedName("data_nascimento")
    val dataNascimento: String,
    @SerializedName("dataNascimentoConjuge")
    val dataNascimentoConjuge: String
) : ApiResponseObject