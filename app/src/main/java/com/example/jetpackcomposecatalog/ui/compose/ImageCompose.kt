package com.example.jetpackcomposecatalog.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.R


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyImage() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ejemplo",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, color = Color.Red, CircleShape)
        )

        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "ejemplo icono",
            tint = Color.Red
        )
    }
}