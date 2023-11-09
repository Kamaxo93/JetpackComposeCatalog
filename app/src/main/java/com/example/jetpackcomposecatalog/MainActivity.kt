package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.jetpackcomposecatalog.ui.compose.MyButton
import com.example.jetpackcomposecatalog.ui.compose.MyProgress
import com.example.jetpackcomposecatalog.ui.compose.MyProgressAdvance
import com.example.jetpackcomposecatalog.ui.compose.MySwitch
import com.example.jetpackcomposecatalog.ui.compose.MyTextField
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
                    MySwitch()
//                    MyTextField(myText) {
//                        myText = it
//                    }
                }
            }
        }
    }
}