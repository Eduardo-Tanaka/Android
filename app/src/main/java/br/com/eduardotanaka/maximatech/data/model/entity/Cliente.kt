package br.com.eduardotanaka.maximatech.data.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.eduardotanaka.maximatech.data.model.api.ClienteResponse
import br.com.eduardotanaka.maximatech.data.model.entity.base.ReflectsApiResponse
import br.com.eduardotanaka.maximatech.data.room.converter.Converters
import kotlinx.parcelize.Parcelize
import org.threeten.bp.LocalDate

@Entity
@Parcelize
data class Cliente(
    @PrimaryKey
    var id: Int = 0,
    var codigo: String = "",
    var razaoSocial: String = "'",
    var nomeFantasia: String = "",
    var cnpj: String = "",
    var ramoAtividade: String = "",
    var endereco: String = "",
    var status: String = "",
    @TypeConverters(Converters::class)
    var contatos: List<Contato> = ArrayList()
) : ReflectsApiResponse<Cliente, ClienteResponse>, Parcelable {
    override fun reflectFrom(apiResponse: ClienteResponse): Cliente {
        apiResponse.let { result ->
            this.id = result.cliente.id
            this.codigo = result.cliente.codigo
            this.razaoSocial = result.cliente.razaoSocial
            this.nomeFantasia = result.cliente.nomeFantasia
            this.cnpj = result.cliente.cnpj
            this.ramoAtividade = result.cliente.ramoAtividade
            this.endereco = result.cliente.endereco
            this.status = result.cliente.status

            val listContatos = ArrayList<Contato>()
            result.cliente.contatos.map {
                listContatos.add(
                    Contato(
                        it.nome,
                        it.telefone,
                        it.celular,
                        it.conjuge,
                        it.tipo,
                        it.time,
                        it.email,
                        LocalDate.parse(it.dataNascimento),
                        it.dataNascimentoConjuge?.let {
                            LocalDate.parse(it)
                        }
                    )
                )
            }

            this.contatos = listContatos
        }

        return this
    }
}