package br.com.eduardotanaka.maximatech.ui.cliente.dados

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.eduardotanaka.maximatech.data.model.entity.Contato
import br.com.eduardotanaka.maximatech.databinding.LayoutContatoBinding
import br.com.eduardotanaka.maximatech.util.DateTimeUtil

class ContatoAdapter(
    var contatos: List<Contato>
) : RecyclerView.Adapter<ContatoAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemBinding =
            LayoutContatoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(contatos[position])
    }

    override fun getItemCount(): Int {
        return contatos.count()
    }

    inner class MainViewHolder(private val rowView: LayoutContatoBinding) :
        RecyclerView.ViewHolder(rowView.root) {
        private lateinit var contato: Contato

        fun bind(contato: Contato) {
            this.contato = contato

            rowView.nome.text = contato.nome
            rowView.telefoneNumero.text = contato.telefone
            rowView.celularNumero.text = contato.celular
            rowView.emailDesc.text = contato.email
            rowView.dataNascDesc.text = DateTimeUtil.defaultFormatter.format(contato.dataNascimento)
            rowView.conjugeNome.text = contato.conjuge
            rowView.dataNascConjDesc.text =
                contato.dataNascimentoConjuge?.let { DateTimeUtil.defaultFormatter.format(contato.dataNascimentoConjuge) }
            rowView.tipoDesc.text = contato.tipo
            rowView.timeDesc.text = contato.time
        }
    }

    fun updateItems(newList: List<Contato>) {
        contatos = newList
        notifyDataSetChanged()
    }
}