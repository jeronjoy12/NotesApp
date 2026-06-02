package com.example.notesapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.Text

@Composable
fun AddButton(
    onAddClick: () -> Unit
) {

    Button(
        onClick = onAddClick
    ) {
        Text("Add")
    }
}