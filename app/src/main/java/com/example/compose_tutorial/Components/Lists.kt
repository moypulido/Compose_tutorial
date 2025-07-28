package com.example.compose_tutorial.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.random.Random

//data class Person(val name: String)

@Composable
fun MyList(modifier: Modifier) {

    val names: List<String> = listOf(
        "John", "Jane", "Doe", "Smith",
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        MyBasicList(names)
//        MyAdvnaceList()
//        MyScrollList()
        MyGridList()
    }
}

@Composable
fun MyBasicList(list: List<String> = emptyList()) {

    LazyColumn(modifier = Modifier.border(1.dp, color = Color.Red)) {
        items(items = list) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, color = Color.Green),
            ) {
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, color = Color.Blue)
                )
            }
        }
    }
}

@Composable
fun MyAdvnaceList(modifier: Modifier = Modifier) {

    var items: List<String> by remember { mutableStateOf(List(100) { "item numero $it" }) }

    LazyColumn(modifier = modifier.border(1.dp, color = Color.Red)) {
        itemsIndexed(items, key = { _, item -> item }) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, color = Color.Green),
            ) {
                Text(
                    text = "$index: $item",
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, color = Color.Blue)
                )
                TextButton(
                    onClick = {
                        items = items.toMutableList().apply {
                            removeAt(index)
                        }
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, color = Color.Magenta)
                        .weight(1f)
                ) {
                    Text(text = "Borrar")
                }
            }

        }
    }
}

@Composable
fun MyScrollList() {
    val listState = rememberLazyListState()
    val courutineScope = rememberCoroutineScope()
    val showButtom by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 5 }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            items(30) { index ->
                Text(
                    text = "Item $index",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .border(1.dp, color = Color.Gray)
                )
            }
        }
        if (showButtom) {
            FloatingActionButton(
                onClick = {
                    courutineScope.launch {
                        listState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Top")
            }
        }
    }
}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numbers by remember { mutableStateOf(List(50) { Random.nextInt(0, 6) }) }
    val colors = listOf(
        Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan, Color.Magenta
    )

    LazyHorizontalGrid(
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(4),
        rows = GridCells.Fixed(5),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        items(numbers) { randomNumber ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(colors[randomNumber])
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "${randomNumber}",

                    )
            }
        }
    }
}
