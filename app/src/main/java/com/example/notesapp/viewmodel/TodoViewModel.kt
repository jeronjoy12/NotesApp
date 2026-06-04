package com.example.notesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.local.Todo
import com.example.notesapp.data.repository.TodoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import android.util.Log


class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    var todoText by mutableStateOf("")
        private set

    val todos = repository
        .getTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    private var recentlyDeletedTodo: Todo? = null

    fun updateText(text: String) {
        todoText = text
    }

    fun addTodo() {

        if (todoText.isNotBlank()) {

            viewModelScope.launch {

                repository.insertTodo(
                    Todo(
                        title = todoText
                    )
                )
            }

            todoText = ""
        }
    }

    fun deleteTodo(todo: Todo) {

        recentlyDeletedTodo = todo

        viewModelScope.launch {

            repository.deleteTodo(todo)
        }
    }
    fun restoreTodo() {

        recentlyDeletedTodo?.let {

            viewModelScope.launch {
                repository.insertTodo(it)
            }

            recentlyDeletedTodo = null
        }
    }
}