package com.example.compose_tutorial.Navigation.Examples

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onClickNavButton: () -> Unit = {}
) {
    var isShowView by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Login",
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            onClickNavButton()
        }) {
            Text("Navegar")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            isShowView = !isShowView
        }) {
            Text(if (isShowView) "Hide Other View" else "Show Other View")
        }
        Spacer(modifier = Modifier.weight(1f))
    }

    if (isShowView) {

        BackHandler {
            isShowView = false
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "This is another view",
                fontSize = 20.sp,
            )
        }

    }
}