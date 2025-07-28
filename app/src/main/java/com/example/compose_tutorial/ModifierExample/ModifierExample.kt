package com.example.compose_tutorial.ModifierExample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.alpha
import androidx.compose.foundation.clickable

@Composable
fun ModifierExample(modifier: Modifier = Modifier){
    Box (
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(3.dp, Color.Cyan)
            .fillMaxSize()
    ){
        Text(
            text = "example from Modifier",
            modifier = modifier
                .border(2.dp, Color.Red)
                .padding(30.dp)
        )
    }
}

@Composable
fun ModifierExamplePreview() {

    // Ejemplo 1: Fondo amarillo y padding
    ModifierExample(
        modifier = Modifier
            .background(Color.Yellow)
            .padding(16.dp)
    )

    // Ejemplo 2: Borde redondeado y fondo azul
    ModifierExample(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Blue, shape = RoundedCornerShape(12.dp))
    )

    // Ejemplo 3: Offset para mover el texto
    ModifierExample(
        modifier = Modifier
            .offset(x = 20.dp, y = 30.dp)
            .background(Color.LightGray)
    )

    // Ejemplo 4: Clip en forma circular y fondo magenta
    ModifierExample(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Magenta)
            .padding(16.dp)
    )

    // Ejemplo 5: Tamaño fijo y fondo verde
    ModifierExample(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
    )

    // Ejemplo 6: Opacidad y borde
    ModifierExample(
        modifier = Modifier
            .alpha(0.5f)
            .border(2.dp, Color.Black)
            .padding(12.dp)
    )

    // Ejemplo 7: Clickable con fondo cyan
    ModifierExample(
        modifier = Modifier
            .background(Color.Cyan)
            .clickable { println("Clicked!") }
            .padding(20.dp)
    )

    // Ejemplo 8: Scroll vertical en un contenedor
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        for (i in 1..5) {
            ModifierExample(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.LightGray)
            )
        }
    }
}
