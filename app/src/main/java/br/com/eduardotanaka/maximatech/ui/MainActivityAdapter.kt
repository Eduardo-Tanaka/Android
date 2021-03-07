package br.com.eduardotanaka.maximatech.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.eduardotanaka.maximatech.R
import br.com.eduardotanaka.maximatech.databinding.LayoutCardBinding

class MainActivityAdapter(
    var cards: List<Card>,
    val context: Context
) : RecyclerView.Adapter<MainActivityAdapter.MainViewHolder>() {

    var onItemSelectedListener: OnItemSelectedListener? = null

    interface OnItemSelectedListener {
        fun onCardClicked(card: Card)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainActivityAdapter.MainViewHolder {
        val itemBinding =
            LayoutCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainActivityAdapter.MainViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount(): Int {
        return cards.count()
    }

    inner class MainViewHolder(private val rowView: LayoutCardBinding) :
        RecyclerView.ViewHolder(rowView.root) {
        private lateinit var card: Card

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(card: Card) {
            this.card = card

            rowView.cardImage.setImageDrawable(
                context.getDrawable(
                    when (this.card.image) {
                        "ic_maxima_pessoas" -> R.drawable.ic_maxima_pessoas
                        "ic_maxima_pedido" -> R.drawable.ic_maxima_pedido
                        "ic_maxima_resumo_vendas" -> R.drawable.ic_maxima_resumo_vendas
                        "ic_maxima_ferramentas" -> R.drawable.ic_maxima_ferramentas
                        else -> R.drawable.ic_maxima_pessoas
                    }
                )
            )
            rowView.cardTitle.text = this.card.title

            rowView.rowCard.setOnClickListener {
                onItemSelectedListener?.onCardClicked(card)
            }
        }
    }

    fun updateItems(newList: List<Card>) {
        cards = newList
        notifyDataSetChanged()
    }

}