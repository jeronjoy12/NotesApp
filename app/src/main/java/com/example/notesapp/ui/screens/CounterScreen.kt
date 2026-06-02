package com.example.notesapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.notesapp.ui.components.CounterButtons
import com.example.notesapp.ui.components.CounterValue

@Composable
fun CounterScreen() {

    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Counter App",
            fontSize = 24.sp
        )

        CounterValue(
            count = count
        )

        CounterButtons(
            onIncrement = {
                count++
            },
            onDecrement = {
                count--
            }
        )
    }
}