package com.example.jetpackcomposecatalog.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MyBasicSlider() {
    var positionSlider by remember {
        mutableFloatStateOf(0f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = positionSlider, onValueChange = { positionSlider = it })
        Text(text = positionSlider.toString(), fontSize = (positionSlider * 100).sp)
    }
}

@Composable
fun MyAdvanceSlider() {
    var positionSlider by remember {
        mutableFloatStateOf(0f)
    }

    var completeValue by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = positionSlider, onValueChange = { positionSlider = it },
            onValueChangeFinished = { completeValue = positionSlider.toString() },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    var positionRange by remember {
        mutableStateOf(0f..10f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        RangeSlider(
            value = positionRange, onValueChange = { positionRange = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "valor inferior ${positionRange.start}")
        Text(text = "valor superior ${positionRange.endInclusive}")
    }
}