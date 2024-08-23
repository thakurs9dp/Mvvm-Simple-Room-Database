package com.s9dp.mvvm_room_database_simple.model.localData.enties

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Task")
data class Task(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "taskId")
    val id: String,
    @ColumnInfo(name = "taskTitle")
    val title: String,
    val description: String,
    val date: Date,
)
