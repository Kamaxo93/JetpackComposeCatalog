package com.example.jetpackcomposecatalog.ui.compose

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalog.R
import com.example.jetpackcomposecatalog.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            Text(text = "Header")
        }
        items(100) {
            Text(text = "Position ${it + 1}")
        }
        item {
            Text(text = "End")
        }
    }
}

@Composable
fun SuperHeroRecycle() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) { superHero ->
            CardHero(superHero) {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroRecycleWithControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val stateCoroutine = rememberCoroutineScope()
    Column {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = rvState,
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHero()) { superHero ->
                CardHero(superHero) {
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            Button(onClick = {
                stateCoroutine.launch {
                    rvState.animateScrollToItem(0)
                }
            }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)) {
                Text(text = "Button cool")
            }

        }
    }
}

@Composable
fun SuperHeroRecycleGrid() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHero()) { superHero ->
            CardHero(superHero) {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            }
        }
    })
}

@Composable
fun CardHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .width(200.dp)
        .clickable { onItemSelected(superHero) }
        .padding(vertical = 8.dp, horizontal = 16.dp)) {
        Column {
            Image(
                painter = painterResource(id = superHero.image),
                contentDescription = "Super Hero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = superHero.name, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher, modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp), fontSize = 8.sp
            )
        }
    }
}

fun getSuperHero() =
    listOf(
        SuperHero(
            name = "Spidermam",
            realName = "peter parker",
            publisher = "marvel",
            image = R.drawable.spiderman
        ),
        SuperHero(
            name = "Wolverine",
            realName = "logan",
            publisher = "marvel",
            image = R.drawable.logan
        ),
        SuperHero(
            name = "Batman",
            realName = "bruce wayne",
            publisher = "dc",
            image = R.drawable.batman
        ),
        SuperHero(name = "Thor", realName = "thor", publisher = "marvel", image = R.drawable.thor),
        SuperHero(
            name = "Flash",
            realName = "jay garrick",
            publisher = "dc",
            image = R.drawable.flash
        ),
        SuperHero(
            name = "Green Lantern",
            realName = "alan scott",
            publisher = "dc",
            image = R.drawable.green_lantern
        ),
        SuperHero(
            name = "Wonder Woman",
            realName = "jiana",
            publisher = "dc",
            image = R.drawable.wonder_woman
        )
    )