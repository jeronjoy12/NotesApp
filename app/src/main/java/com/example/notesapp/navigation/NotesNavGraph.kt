package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.ui.screens.DetailScreen
import com.example.notesapp.ui.screens.TodoScreen
import com.example.notesapp.data.repository.TodoRepository

@Composable
fun NotesNavGraph(
    repository: TodoRepository
)  {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {
            TodoScreen(
                navController = navController,
                repository = repository
            )
        }
        composable(
            route = "detail/{id}"
        ) { backStackEntry ->

            val id =
                backStackEntry.arguments
                    ?.getString("id")
                    ?.toIntOrNull() ?: 0

            DetailScreen(
                id = id,
                navController = navController
            )
        }
        }

}