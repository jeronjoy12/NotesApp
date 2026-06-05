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



class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    var todoText by mutableStateOf("")
        private set
    var searchQuery by mutableStateOf("")
        private set

    val todos = repository
        .getTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    var errorMessage by mutableStateOf<String?>(null)
        private set
    private var recentlyDeletedTodo: Todo? = null
    val filteredTodos
        get() = todos.value.filter {

            it.title.contains(
                searchQuery,
                ignoreCase = true
            )
        }

    fun updateText(text: String) {
        todoText = text
    }

    fun addTodo() {

        if (todoText.isNotBlank()) {

            viewModelScope.launch {

                try {

                    repository.insertTodo(
                        Todo(
                            title = todoText
                        )
                    )

                } catch (e: Exception) {

                    errorMessage = "Database Error"
                }
            }

            todoText = ""
        }
    }

    fun deleteTodo(todo: Todo) {

        recentlyDeletedTodo = todo

        viewModelScope.launch {

            try {

                repository.deleteTodo(todo)

            } catch (e: Exception) {

                errorMessage = "Database Error"
            }
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
    fun updateSearchQuery(query: String) {
        searchQuery = query
    }
    fun clearError() {
        errorMessage = null
    }
    fun testError() {
        errorMessage = "Database Error"
    }
}