package br.com.eduardotanaka.maximatech.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.eduardotanaka.maximatech.data.model.entity.RetrofitTeste
import br.com.eduardotanaka.maximatech.data.room.dao.base.BaseDao

@Dao
abstract class RetrofitTesteDao : BaseDao<RetrofitTeste>() {

    @Query("SELECT * FROM RetrofitTeste")
    abstract fun getAll(): List<RetrofitTeste>
}