package com.example.jetpackcomposecatalog.ui.compose

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(checked = state, onCheckedChange = { state = !state })
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkbox(
            checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Red
            )
        )
    }
}

@Composable
fun MyTextCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = !state },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red
                )
            )
            Spacer(Modifier.padding(2.dp))
            Text(text = "Ejemplo 1")
        }
    }
}

@Composable
fun MyTriState() {
    var state by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = state, onClick = {
        state = when (state) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }

    val desserts = listOf("helado", "café", "natillas", "suso", "napolitanas")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable {
                    expanded = true
                }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach {
                DropdownMenuItem(text = { Text(text = it) }, onClick = {
                    expanded = false
                    selectedText = it
                })
            }
        }
    }

}

@Composable
fun MyTextCheckBoxCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected, onCheckedChange = {
                checkInfo.onChangedSelected(!checkInfo.selected)
            }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Red
            )
        )
        Spacer(Modifier.padding(2.dp))
        Text(text = checkInfo.title)
    }
}

data class CheckInfo(
    val title: String, var selected: Boolean = false, var onChangedSelected: (Boolean) -> Unit
)

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> = titles.map {
    var status by rememberSaveable {
        mutableStateOf(false)
    }
    CheckInfo(
        title = it,
        selected = status,
        onChangedSelected = { newStatus -> status = newStatus })
}

@Composable
fun MyRadioButton(name: String, selected: String, onChangedSelected: (String) -> Unit) {
    Row(Modifier.padding(14.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = name == selected, onClick = { onChangedSelected(name) }, Modifier.padding(end = 8.dp))
        Text(text = name, fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRadio() {
    MyRadioButton(name = "casa", selected = "casa", onChangedSelected = {} )
}