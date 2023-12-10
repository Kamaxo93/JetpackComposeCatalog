package com.example.jetpackcomposecatalog.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcomposecatalog.model.Routes

@Composable
fun ScreenOne(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "Pantalla 1",
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Screen2.route) })
    }
}

@Composable
fun ScreenTwo(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Pantalla 2",
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Screen3.route) })
    }
}

@Composable
fun ScreenThree(navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Pantalla 3",
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate("Screen_4/camacho")
                })
    }
}
@Composable
fun ScreenFour(navigationController: NavHostController, name: String) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.Screen5.createUrlRoute(5))
                })
    }
}

@Composable
fun ScreenFive(navigationController: NavHostController, numberScreen: Int) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "pantalla $numberScreen",
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { })
    }
}