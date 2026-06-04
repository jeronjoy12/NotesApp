package com.example.notesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.notesapp.data.repository.TodoRepository
import com.example.notesapp.ui.components.AddButton
import com.example.notesapp.ui.components.TodoCard
import com.example.notesapp.ui.components.TodoInput
import com.example.notesapp.viewmodel.TodoViewModel
import com.example.notesapp.viewmodel.TodoViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun TodoScreen(
    navController: NavController,
    repository: TodoRepository
) {

    val todoViewModel: TodoViewModel = viewModel(
        factory = TodoViewModelFactory(repository)
    )

    val todos by todoViewModel.todos.collectAsState()

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Todo App",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            TodoInput(
                value = todoViewModel.todoText,
                onValueChange = {
                    todoViewModel.updateText(it)
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            AddButton(
                onAddClick = {
                    todoViewModel.addTodo()
                }
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {

                items(
                    todos,
                    key = { it.id }
                ) { todo ->

                    val dismissState =
                        rememberSwipeToDismissBoxState(
                            confirmValueChange = {

                                todoViewModel.deleteTodo(todo)

                                coroutineScope.launch {

                                    val result =
                                        snackbarHostState.showSnackbar(
                                            message = "Todo Deleted",
                                            actionLabel = "UNDO"
                                        )

                                    if (
                                        result ==
                                        SnackbarResult.ActionPerformed
                                    ) {
                                        todoViewModel.restoreTodo()
                                    }
                                }

                                true
                            }
                        )

                    SwipeToDismissBox(
                        state = dismissState,

                        backgroundContent = {

                            Text(
                                text = "Delete",
                                modifier = Modifier.padding(16.dp)
                            )
                        }

                    ) {

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
    }
}