package com.example.compose_tutorial.Advance

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun MyInteractionSource(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        DerivatedStateExample()
        Spacer(modifier = Modifier.size(20.dp))
        IsPressedInteractionExample()
        Spacer(modifier = Modifier.size(20.dp))
        LaunchEffectExample()
    }
}

@Composable
fun DerivatedStateExample() {

    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

    val isFormValid by remember(email, password) {
        derivedStateOf {
            email.contains("@") && email.contains(".") && password.length >= 6
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(300.dp)
            .border(width = 5.dp, color = Color.Magenta)
    ) {
        TextField(value = email, onValueChange = { email = it }, label = { Text(text = "Email") })
        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") })
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = if (isFormValid) "Form is valid" else "Form is invalid",
            color = if (isFormValid) Color.Green else Color.Red
        )

    }
}

@Composable
fun LaunchEffectExample() {
    var timeleft by remember { mutableIntStateOf(5) }
    var isLaunched by remember { mutableStateOf(false) }

    LaunchedEffect(timeleft) {
        if (timeleft > 0) {
            delay(timeMillis = 1000L)
            timeleft--
        }
    }

    LaunchedEffect(Unit) {
        delay(5000L)
        isLaunched = true
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(150.dp)
            .border(width = 5.dp, color = Color.Blue)
    ) {
        if (timeleft > 0) {
            Text(text = "Time left: $timeleft")
        } else {
            Text(text = "Time's up!")
        }

        if (isLaunched) {
            Text(text = "Launched Effect Executed")
        } else {
            Text(text = "Waiting for Launch Effect")
        }
    }

}


@Composable
fun IsPressedInteractionExample() {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = Modifier
            .size(150.dp)
            .border(width = 5.dp, color = if (isPressed) Color.Green else Color.Red)
            .clickable(interactionSource = interactionSource, indication = null) {}
    )
}

