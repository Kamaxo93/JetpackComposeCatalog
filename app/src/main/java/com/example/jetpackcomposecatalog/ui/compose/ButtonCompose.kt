package com.example.jetpackcomposecatalog.ui.compose

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyButton() {
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { Toast.makeText(context, "Prueba Button", Toast.LENGTH_SHORT).show() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue
            ),
            enabled = false,
            border = BorderStroke(2.dp, Color.Green),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Aceptar")
        }

        OutlinedButton(
            onClick = { Toast.makeText(context, "Prueba Button", Toast.LENGTH_SHORT).show() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Aceptar")
        }

        TextButton(
            onClick = { Toast.makeText(context, "Prueba Button", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Aceptar")
        }
    }
}
