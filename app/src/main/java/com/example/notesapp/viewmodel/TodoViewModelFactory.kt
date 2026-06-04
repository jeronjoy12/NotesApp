package com.example.notesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.data.repository.TodoRepository

class TodoViewModelFactory(
    private val repository: TodoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return TodoViewModel(
            repository
        ) as T
    }
}