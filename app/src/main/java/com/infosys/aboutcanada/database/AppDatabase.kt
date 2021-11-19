package com.infosys.aboutcanada.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.infosys.aboutcanada.model.RowsItem

@Database(entities = [RowsItem::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun aboutDao(): AboutDao?

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "AboutPojo.db")
                .allowMainThreadQueries()
                .build()
    }
}