package com.s9dp.mvvm_room_database_simple.MVVM_2.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.s9dp.mvvm_room_database_simple.model.localData.database.Converters

@Database(entities = [Todo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun getTodoDao(): TodoDao

    companion object {

        private const val DATABASE_NAME = "todo_db_table"

        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, TodoDatabase::class.java, DATABASE_NAME
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
