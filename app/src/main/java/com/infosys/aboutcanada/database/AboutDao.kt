package com.infosys.aboutcanada.database

import androidx.room.*
import com.infosys.aboutcanada.model.RowsItem

@Dao
interface AboutDao {
    @Insert
    fun insertAll(users: List<RowsItem?>?)

    @Query("DELETE FROM AboutCanada")
    fun deleteAll()

    @Query("SELECT * FROM AboutCanada")
    fun getAllData(): List<RowsItem?>?
}