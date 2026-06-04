package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.ui.screens.CounterScreen
import com.example.notesapp.ui.screens.TodoScreen
import androidx.compose.material3.Text
import com.example.notesapp.data.local.DatabaseProvider
import com.example.notesapp.data.repository.TodoRepository
import com.example.notesapp.navigation.NotesNavGraph

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

            NotesNavGraph(
                repository = repository
            )
        }
    }
}
