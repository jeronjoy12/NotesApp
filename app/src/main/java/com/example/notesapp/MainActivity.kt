package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.ui.screens.CounterScreen
import com.example.notesapp.ui.screens.TodoScreen
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)

            ) {

                CounterScreen()

                TodoScreen()
            }
        }
    }
}
