package com.example.notesapp.data.repository

import com.example.notesapp.data.local.Todo
import com.example.notesapp.data.local.TodoDao

class TodoRepository(
    private val todoDao: TodoDao
) {

    fun getTodos() =
        todoDao.getTodos()

    suspend fun insertTodo(todo: Todo) =
        todoDao.insertTodo(todo)

    suspend fun deleteTodo(todo: Todo) =
        todoDao.deleteTodo(todo)
}