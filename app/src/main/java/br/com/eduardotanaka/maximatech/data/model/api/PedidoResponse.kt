package br.com.eduardotanaka.maximatech.data.model.api

import br.com.eduardotanaka.maximatech.data.model.api.base.ApiResponseObject

/*
// https://private-anon-e8478c446c-maximatech.apiary-mock.com/android/pedido

{
  "pedidos": [
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
}
 */
data class PedidoResponse(
    val pedidos: List<PedidoModel>
) : ApiResponseObject