package com.example.compose_tutorial.state

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun myState(modifier: Modifier = Modifier) {

    var number by rememberSaveable { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        stateExample1(number) { number += 1 }
        stateExample2(number) { number += 1 }
    }
}


@Composable
fun stateExample1(number: Int, onclick: () -> Unit) {
//    var number by rememberSaveable { mutableIntStateOf(0) }

    Text(
        text = "push $number",
        modifier = Modifier
            .clickable {
                onclick()
            }
            .border(3.dp, Color.Red)
            .padding(40.dp)
    )
}

@Composable
fun stateExample2(number: Int, onclick: () -> Unit) {
//    var number by rememberSaveable { mutableIntStateOf(0) }

    Text(
        text = "push $number",
        modifier = Modifier
            .clickable {
                onclick()
            }
            .border(3.dp, Color.Red)
            .padding(40.dp)
    )

}