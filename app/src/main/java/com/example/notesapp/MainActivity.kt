package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.notesapp.data.local.DatabaseProvider
import com.example.notesapp.data.repository.TodoRepository
import com.example.notesapp.navigation.NotesNavGraph
import com.example.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database =
            DatabaseProvider.getDatabase(this)

        val repository =
            TodoRepository(
                database.todoDao()
            )

        setContent {
            NotesAppTheme(darkTheme = true) {
                NotesNavGraph(
                    repository = repository
                )
            }
        }
    }
}
