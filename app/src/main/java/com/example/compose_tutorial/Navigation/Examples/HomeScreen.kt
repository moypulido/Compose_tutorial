package com.example.compose_tutorial.Navigation.Examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetails: (String) -> Unit = {},
    onClickNavButton: () -> Unit = {}
) {

    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = "Home",
            fontSize = 24.sp,
        )
        Spacer(modifier = modifier.weight(1f))
        Row {
            TextField(value = text, onValueChange = { text = it }, label = { Text("Digite um ID") })
            Button(onClick = { navigateToDetails(text) }) { Text("Navegar") }
        }
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = {
            onClickNavButton()
        }) {
            Text("Navegar")
        }
        Spacer(modifier = modifier.weight(1f))
    }
}