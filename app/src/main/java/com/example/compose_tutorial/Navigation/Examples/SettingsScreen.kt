package com.example.compose_tutorial.Navigation.Examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.compose_tutorial.Navigation.Models.SettingsModel

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    settingsModel: SettingsModel = SettingsModel(
        userId = "12345",
        name = "John Doe",
        theme = "Light"
    ),
    onClickNavButton: () -> Unit = { }
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = "Settings",
            fontSize = 24.sp,
        )
        Spacer(modifier = modifier.weight(1f))
        Column {
            Text(text = "ID do Usuário: ${settingsModel.userId}")
            Text(text = "Nome: ${settingsModel.name}")
            Text(text = "Tema: ${settingsModel.theme}")
        }
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = {
            onClickNavButton()
        }) {
            Text("back to login")
        }
        Spacer(modifier = modifier.weight(1f))
    }
}