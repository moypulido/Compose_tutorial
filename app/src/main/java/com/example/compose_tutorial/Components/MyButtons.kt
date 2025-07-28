package com.example.compose_tutorial.Components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        MyButton()
        MyButtonMod()
        MyOutlinedButton()
        MyTextButton()
        MyElevatedButton()
        MyFilledTonalButton()
    }
}

@Composable
fun MyButton() {
    Button(
        onClick = {
            Log.i("moises", "push button")
        }
    ) {
        Text(
            text = "Push me"
        )
    }
}

@Composable
fun MyButtonMod() {
    Button(
        shape = RoundedCornerShape(10),
        border = BorderStroke(3.dp, Color.Red),
        onClick = {
            Log.i("moises", "push button")
        }
    ) {
        Text(
            text = "Push me"
        )
    }
}

@Composable
fun MyOutlinedButton() {
    OutlinedButton(
        onClick = {},
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 5.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text("Push me")
    }
}

@Composable
fun MyTextButton() {
    TextButton(
        onClick = {},
    ) {
        Text("Click me")
    }
}

@Composable
fun MyElevatedButton() {
    ElevatedButton(
        onClick = {},
    ) {
        Text("Elevated Button")
    }
}

@Composable
fun MyFilledTonalButton() {
    FilledTonalButton(
        onClick = {},
    ) {
        Text("Filled Tonal")
    }
}