package com.example.compose_tutorial.Animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_tutorial.Navigation.Examples.HomeScreen
import com.example.compose_tutorial.Navigation.Examples.LoginScreen
import com.example.compose_tutorial.Navigation.Examples.SettingsScreen

@Composable
fun MyCrossfade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("home") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row {
            Text(
                text = "Home",
                modifier = Modifier
                    .clickable(onClick = { currentScreen = "home" })
                    .padding(16.dp)
            )
            Text(
                text = "Profile",
                modifier = Modifier
                    .clickable(onClick = { currentScreen = "login" })
                    .padding(16.dp)
            )
            Text(
                text = "Settings",
                modifier = Modifier
                    .clickable(onClick = { currentScreen = "settings" })
                    .padding(16.dp)
            )
        }
        Crossfade(
            targetState = currentScreen,


            ) { screen ->
            when (screen) {
                "home" -> HomeScreen()
                "login" -> LoginScreen()
                "settings" -> SettingsScreen()
            }
        }

    }

}