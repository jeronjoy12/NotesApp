package com.example.notesapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun CounterValue(
    count: Int
) {
    Text(
        text = count.toString(),
        fontSize = 32.sp
    )
}