package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposecatalog.model.Routes
import com.example.jetpackcomposecatalog.ui.compose.ScreenFive
import com.example.jetpackcomposecatalog.ui.compose.ScreenFour
import com.example.jetpackcomposecatalog.ui.compose.ScreenOne
import com.example.jetpackcomposecatalog.ui.compose.ScreenThree
import com.example.jetpackcomposecatalog.ui.compose.ScreenTwo
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var myText by rememberSaveable { mutableStateOf("") }
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Screen1.route
                    ) {
                        composable(route = Routes.Screen1.route) { ScreenOne(navigationController) }
                        composable(route = Routes.Screen2.route) { ScreenTwo(navigationController) }
                        composable(route = Routes.Screen3.route) { ScreenThree(navigationController) }
                        composable(route = Routes.Screen4.route) { backStackEntry ->
                            ScreenFour(
                                navigationController,
                                backStackEntry.arguments?.getString("name").orEmpty()
                            )
                        }
                        composable(
                            route = Routes.Screen5.route,
                            arguments = listOf(navArgument("numberPage") { type = NavType.IntType })
                        ) { backStackEntry ->
                            ScreenFive(navigationController, backStackEntry.arguments?.getInt("numberPage") ?: 0)
                        }
                    }
                    /* var show by remember {
                         mutableStateOf(false)
                     }
                     Column(
                         Modifier.fillMaxSize(),
                         horizontalAlignment = Alignment.CenterHorizontally,
                         verticalArrangement = Arrangement.Center
                     ) {
                         Button(onClick = { show = true }) {
                             Text(text = "Accionar dialogo")
                         }
                         MyCustomDialogComplete(show = show, onActionDismiss = {show = it}, onClickElement = {
                             Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
                         })
 //                        getOptions(
 //                            titles = listOf(
 //                                "camacho",
 //                                "carmen",
 //                                "hector",
 //                                "dylan"
 //                            )
 //                        ).forEach {
 //                            MyTextCheckBoxCompleted(checkInfo = it)
 //                        }
                     }*/
                }
            }
        }
    }
}