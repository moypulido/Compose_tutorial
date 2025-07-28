package com.example.compose_tutorial.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyOtherComponents(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        MyCardComponent()
        MyDividerComponent()
        MyBadgeComponent()
    }
}

@Composable
fun MyDividerComponent() {
    // Implementation of the divider component
    // This could be a simple horizontal line or a more complex design
    HorizontalDivider(
        thickness = 1.dp,
        color = Color.Red
    )
}

@Composable
fun MyBadgeComponent() {
    Badge(
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Text("Badge Text")
    }
}

@Composable
fun MyCardComponent() {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "This is a Card Component",
            modifier = Modifier.padding(16.dp)
        )
    }
}