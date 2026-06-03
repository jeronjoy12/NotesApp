package com.example.notesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.notesapp.model.Todo

class TodoViewModel : ViewModel() {

    var todoText by mutableStateOf("")
        private set


    val todos = mutableStateListOf<Todo>()

    fun updateText(text: String) {
        todoText = text
    }

    fun addTodo() {

        if (todoText.isNotBlank()) {

            todos.add(
                Todo(
                    id = todos.size + 1,
                    title = todoText
                )
            )

            todoText = ""
        }
    }
}
