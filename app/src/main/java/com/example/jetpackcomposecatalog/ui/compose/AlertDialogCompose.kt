package com.example.jetpackcomposecatalog.ui.compose

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.jetpackcomposecatalog.R

@Composable
fun MyCustomDialogComplete(
    show: Boolean,
    onActionDismiss: (Boolean) -> Unit,
    onClickElement: (String) -> Unit
) {
    var selected by remember {
        mutableStateOf("")
    }
    if (show) {
        Dialog(
            onDismissRequest = { onActionDismiss(false) },
            properties = DialogProperties(
                dismissOnBackPress = false
            )
        ) {
            Card {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TittleDialog(
                        "Phone ringtone",
                        modifier = Modifier
                            .padding(24.dp)
                            .align(Alignment.Start)

                    )
                    MyDivider()
                    MyRadioButton(name = "camacho", selected) { selected = it }
                    MyRadioButton(name = "carmen", selected) { selected = it }
                    MyRadioButton(name = "hector", selected) { selected = it }
                    MyRadioButton(name = "dylan", selected) { selected = it }
                    MyDivider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Cancel")
                        }
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "OK")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onActionDismiss: (Boolean) -> Unit,
    onClickElement: (String) -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onActionDismiss(false) },
            properties = DialogProperties(
                dismissOnBackPress = false
            )
        ) {
            Column(
                Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TittleDialog("Con quien quieres iniciar sesion")
                AccountItem(email = "ejemplo1@test.com", drawable = R.drawable.avatar) {
                    onClickElement(it)
                }
                AccountItem(email = "ejemplo1@test.com", drawable = R.drawable.avatar) {
                    onClickElement(it)
                }
                AccountItem(email = "new account", drawable = R.drawable.add) {
                    onClickElement(it)
                }
            }
        }
    }
}

@Composable
fun TittleDialog(text: String, modifier: Modifier = Modifier.padding(12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int, onClickElement: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickElement(email) }) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onActionDismiss: (Boolean) -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onActionDismiss(false) },
            properties = DialogProperties(
                dismissOnBackPress = false
            )
        ) {
            Column(
                Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Esto es un ejemplo", Modifier.padding(40.dp))
            }
        }
    }
}

@Composable
fun MyAlertDialog(show: Boolean, onActionDismiss: (Boolean) -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onActionDismiss(false) },
            confirmButton = {
                TextButton(onClick = { onActionDismiss(false) }) {
                    Text(text = "Confirmacion")
                }
            },
            title = { Text(text = "Primer Dialogo") },
            text = { Text(text = "este es mi primer dialogo en compose :)") })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDialog() {
    MyCustomDialogComplete(
        true,
        onClickElement = {},
        onActionDismiss = {}
    )
}