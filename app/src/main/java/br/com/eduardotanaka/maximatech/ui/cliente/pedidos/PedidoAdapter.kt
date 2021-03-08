package br.com.eduardotanaka.maximatech.ui.cliente.pedidos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.data.model.entity.Pedido
import br.com.eduardotanaka.maximatech.databinding.LayoutPedidoBinding
import br.com.eduardotanaka.maximatech.util.DateTimeUtil.horaMinutoFormatter
import com.bumptech.glide.Glide
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class PedidoAdapter(
    var pedidos: List<Pedido>
) : RecyclerView.Adapter<PedidoAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemBinding =
            LayoutPedidoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(pedidos[position])
    }

    override fun getItemCount(): Int {
        return pedidos.count()
    }

    inner class MainViewHolder(private val rowView: LayoutPedidoBinding) :
        RecyclerView.ViewHolder(rowView.root) {
        private lateinit var pedido: Pedido

        fun bind(pedido: Pedido) {
            this.pedido = pedido

            //rowView.icon.setImageDrawable(rowView.root.context.getDrawable(R.drawable.ic_maxima_em_processamento))
            rowView.numeroPedido.text = "${pedido.numeroPedRca} / ${pedido.numeroPedErp}"
            rowView.cliente.text = "${pedido.codigoCliente} - ${pedido.nomeCliente}"
            rowView.status.text = pedido.status
            rowView.critica.setImageDrawable(
                when (pedido.critica) {
                    "SUCESSO" -> rowView.root.context.getDrawable(R.drawable.ic_maxima_critica_sucesso)
                    "FALHA_PARCIAL" -> rowView.root.context.getDrawable(R.drawable.ic_maxima_critica_alerta)
                    else -> null
                }
            )
            rowView.data.text = horaMinutoFormatter.format(
                LocalDateTime.parse(
                    pedido.data, DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd'T'HH:mm:ssZZZ"
                    )
                )
            )
            rowView.icon2.setImageDrawable(pedido.legendas?.let { rowView.root.context.getDrawable(R.drawable.ic_maxima_legenda_corte) })
            rowView.preco.text = "R$ ???"
        }
    }

    fun updateItems(newList: List<Pedido>) {
        pedidos = newList
        notifyDataSetChanged()
    }
}