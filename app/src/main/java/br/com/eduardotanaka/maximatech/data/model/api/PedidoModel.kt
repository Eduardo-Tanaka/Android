package br.com.eduardotanaka.maximatech.data.model.api

import br.com.eduardotanaka.maximatech.data.model.api.base.ApiResponseObject
import com.google.gson.annotations.SerializedName

/*
{
  "numero_ped_Rca": 542180,
  "numero_ped_erp": "6421800987",
  "codigoCliente": "848.246",
  "NOMECLIENTE": "Burger",
  "data": "2018-09-06T10:12:21-0300",
  "status": "Processado",
  "critica": "SUCESSO",
  "tipo": "ORCAMENTO",
  "legendas": [
    "PEDIDO_SOFREU_CORTE",
    "PEDIDO_FEITO_TELEMARKETING"
  ]
},
 */
data class PedidoModel(
    @SerializedName("numero_ped_Rca")
    val numeroPedRca: Int,
    @SerializedName("numero_ped_erp")
    val numeroPedErp: String,
    val codigoCliente: String,
    @SerializedName("NOMECLIENTE")
    val nomeCliente: String,
    val data: String,
    val status: String,
    val critica: String,
    val tipo: String,
    val legendas: List<String>
) : ApiResponseObject