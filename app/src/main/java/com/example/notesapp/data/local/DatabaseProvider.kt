package com.example.notesapp.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


object DatabaseProvider {
    val MIGRATION_1_2 = object : Migration(1, 2) {

        override fun migrate(database: SupportSQLiteDatabase) {

            database.execSQL(
                """
            ALTER TABLE todos
            ADD COLUMN priority INTEGER NOT NULL DEFAULT 0
            """
            )
        }
    }

    private var INSTANCE: TodoDatabase? = null

    fun getDatabase(
        context: Context
    ): TodoDatabase {

        return INSTANCE ?: synchronized(this) {

            val instance = Room.databaseBuilder(
                context,
                TodoDatabase::class.java,
                "todo_database"
            )
                .addMigrations(MIGRATION_1_2)
                .build()

            INSTANCE = instance

            instance
        }
    }
}