package com.example.compose_tutorial.Navigation.Examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.compose_tutorial.Navigation.Models.SettingsModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    id: String,
    onClickNavButton: (SettingsModel) -> Unit
) {

    val settings = SettingsModel(
        userId = "123",
        name = "John Doe",
        theme = "Light"
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = "Detail (ID: $id)",
            fontSize = 24.sp,
        )
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = {
            onClickNavButton(settings)
        }) {
            Text("Settings")
        }
        Spacer(modifier = modifier.weight(1f))
    }
}