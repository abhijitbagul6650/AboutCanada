package com.infosys.aboutcanada.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.infosys.aboutcanada.constants.AppConstants
import com.infosys.aboutcanada.model.AboutCanadaPojo
import com.infosys.aboutcanada.model.RowsItem
import java.util.*

@Dao
interface AboutDao {
    @Insert
    fun insertAll(users: List<RowsItem?>?)

    @Query("DELETE FROM " + AppConstants.TABLE_ABOUT_CANADA)
    fun deleteAll()

    @Query("SELECT * FROM "+ AppConstants.TABLE_ABOUT_CANADA)
    fun getAllData(): List<RowsItem?>?
}