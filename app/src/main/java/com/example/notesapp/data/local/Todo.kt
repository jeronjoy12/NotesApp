package com.example.notesapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val body: String = "",

    val timestamp: Long = System.currentTimeMillis(),

    val priority: Int = 0
)