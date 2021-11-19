package com.infosys.aboutcanada.api

import com.infosys.aboutcanada.database.AppDatabase
import com.infosys.aboutcanada.model.RowsItem

class DatabaseRepository(private val db: AppDatabase) {
    fun insert(item: List<RowsItem?>?) = db.aboutDao()?.insertAll(item)
    fun delete() = db.aboutDao()?.deleteAll()
    fun getAllData() = db.aboutDao()?.getAllData()
}