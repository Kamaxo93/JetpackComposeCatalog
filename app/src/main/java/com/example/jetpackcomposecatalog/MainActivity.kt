package com.example.jetpackcomposecatalog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import com.example.jetpackcomposecatalog.ui.compose.MyAdvanceSlider
import com.example.jetpackcomposecatalog.ui.compose.MyAlertDialog
import com.example.jetpackcomposecatalog.ui.compose.MyBadgeBox
import com.example.jetpackcomposecatalog.ui.compose.MyBasicSlider
import com.example.jetpackcomposecatalog.ui.compose.MyButton
import com.example.jetpackcomposecatalog.ui.compose.MyCard
import com.example.jetpackcomposecatalog.ui.compose.MyCheckBox
import com.example.jetpackcomposecatalog.ui.compose.MyCustomDialog
import com.example.jetpackcomposecatalog.ui.compose.MyCustomDialogComplete
import com.example.jetpackcomposecatalog.ui.compose.MyDivider
import com.example.jetpackcomposecatalog.ui.compose.MyDropDownMenu
import com.example.jetpackcomposecatalog.ui.compose.MyProgress
import com.example.jetpackcomposecatalog.ui.compose.MyProgressAdvance
import com.example.jetpackcomposecatalog.ui.compose.MyRangeSlider
import com.example.jetpackcomposecatalog.ui.compose.MySimpleCustomDialog
import com.example.jetpackcomposecatalog.ui.compose.MySwitch
import com.example.jetpackcomposecatalog.ui.compose.MyTextCheckBox
import com.example.jetpackcomposecatalog.ui.compose.MyTextCheckBoxCompleted
import com.example.jetpackcomposecatalog.ui.compose.MyTextField
import com.example.jetpackcomposecatalog.ui.compose.MyTriState
import com.example.jetpackcomposecatalog.ui.compose.SimpleRecyclerView
import com.example.jetpackcomposecatalog.ui.compose.SuperHeroRecycle
import com.example.jetpackcomposecatalog.ui.compose.SuperHeroRecycleGrid
import com.example.jetpackcomposecatalog.ui.compose.SuperHeroRecycleWithControlView
import com.example.jetpackcomposecatalog.ui.compose.getOptions
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
                    SuperHeroRecycleWithControlView()
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