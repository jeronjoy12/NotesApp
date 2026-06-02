package com.example.notesapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CounterButtons(
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Button(
            onClick = onDecrement
        ) {
            Text("-")
        }

        Button(
            onClick = onIncrement
        ) {
            Text("+")
        }
    }
}