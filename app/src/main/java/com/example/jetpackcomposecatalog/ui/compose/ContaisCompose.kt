package com.example.jetpackcomposecatalog.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

@Composable
fun MyRow() {
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "camacho",
            modifier = Modifier
                .background(Color.Red)
        )
        Text(
            text = "carmen",
            modifier = Modifier
                .background(Color.Blue)
        )
        Text(
            text = "hector",
            modifier = Modifier
                .background(Color.Cyan)
        )
        Text(
            text = "dylan",
            modifier = Modifier
                .background(Color.Green)
        )

    }

    @Composable
    fun MyColumn() {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "camacho",
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = "carmen",
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = "hector",
                modifier = Modifier
                    .background(Color.Cyan)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = "dylan",
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .width(120.dp)
                    .height(50.dp)
                    .padding(6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .background(Color.Black)
                ) {
                    Text(text = "Estoy es un ejemplo para ver el scroll", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun ExampleOne() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        MySpace(size = 30, false)
        Row(Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            MySpace(size = 20, true)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        MySpace(size = 30, false)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }

    }
}

@Composable
fun MySpace(size: Int, isHorizontal: Boolean) {
    Spacer(modifier = if (isHorizontal) Modifier.width(size.dp) else Modifier.height(size.dp))
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(text = "Prueba card")
            Text(text = "Prueba card")
            Text(text = "Prueba card")

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = { Badge(containerColor = Color.Green) { Text("8", color = Color.Blue) } },
        modifier = Modifier.padding(16.dp),
    ) {
        Icon(painter = rememberVectorPainter(image = Icons.Default.Star), contentDescription = "")
    }
}

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier.padding(vertical = 16.dp),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogTheme {
        ExampleOne()
    }
}