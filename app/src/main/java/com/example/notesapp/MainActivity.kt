package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Greeting(name = "Jeron")
        }
    }
}

@Composable
fun Greeting(name: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SHello, $name!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6650A4)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Day 1 — Compose is fun!",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting(name = "Preview User")
}