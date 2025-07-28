package com.example.compose_tutorial.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val myCustomStyle = TextStyle(
    fontSize = 30.sp,
    color = Color.Blue
)

@Composable
fun MyText(modifier: Modifier = Modifier) {

//    material ins only avalible during the composition
    val mergeStyle = MaterialTheme.typography.bodyLarge.merge(
        TextStyle(color = Color.Red, fontSize = 24.sp)
    )

    Column(modifier = modifier.fillMaxSize()) {

        Text(
            text = "pepe",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "pepe rojo",
            style = mergeStyle
        )

        Text(
            text = "pepe azul", style = myCustomStyle
        )
    }
}
