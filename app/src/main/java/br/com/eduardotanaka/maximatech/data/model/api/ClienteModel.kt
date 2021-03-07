package br.com.eduardotanaka.maximatech.data.model.api

import br.com.eduardotanaka.maximatech.data.model.api.base.ApiResponseObject
import com.google.gson.annotations.SerializedName

/*
{
    "id": 30987,
    "codigo": "40795A",
    "razao_social": "Máxima Sistemas S/A",
    "nomeFantasia": "Máxima Sistemas",
    "cnpj": "10.766.206/002-61",
    "ramo_atividade": "Sistemas",
    "endereco": "Avenida 136 - Setor Sul - Goiânia/Goiás",
    "status": "Indefinido",
    "contatos": [
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
    ]
}
 */
data class ClienteModel(
    val id: Int,
    val codigo: String,
    @SerializedName("razao_social")
    val razaoSocial: String,
    val nomeFantasia: String,
    val cnpj: String,
    @SerializedName("ramo_atividade")
    val ramoAtividade: String,
    val endereco: String,
    val status: String,
    val contatos: List<ContatoModel>
) : ApiResponseObject