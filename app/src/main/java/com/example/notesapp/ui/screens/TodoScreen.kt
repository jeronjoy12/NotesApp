package com.example.notesapp.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import com.example.notesapp.ui.components.AddButton
import com.example.notesapp.ui.components.TodoCard
import com.example.notesapp.ui.components.TodoInput
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.viewmodel.TodoViewModel

@Composable
fun TodoScreen(
    navController: NavController
) {

    val todoViewModel: TodoViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Todo App",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        TodoInput(
            value = todoViewModel.todoText,
            onValueChange = {
                todoViewModel.updateText(it)
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        AddButton(
            onAddClick = {
                todoViewModel.addTodo()
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {

            items(todoViewModel.todos) { todo ->

                TodoCard(
                    todo = todo.title,
                    onClick = {

                        navController.navigate(
                            "detail/${todo.id}"
                        )

                    }
                )
            }
        }
    }
}