package com.example.jetpackcomposecatalog.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(32.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar Perfil")
        }
    }
}

@Composable
fun MyProgressAdvance() {
    var progressLoading by rememberSaveable {
        mutableFloatStateOf(0.1f)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressLoading)

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            if (progressLoading <= 1.0f) {
                Button(onClick = { progressLoading += 0.1f }) {
                    Text(text = "Aumentar proceso")

                }
                Button(onClick = { progressLoading -= 0.1f }) {
                    Text(text = "disminir proceso")

                }
            }
        }
    }
}