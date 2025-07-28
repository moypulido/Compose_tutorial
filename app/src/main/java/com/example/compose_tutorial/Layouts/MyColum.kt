package com.example.compose_tutorial.Layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyColum(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .border(1.dp, Color.Red)
            .verticalScroll(rememberScrollState())
    ){
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
        Text(text = "hola 1", modifier = Modifier.background(Color.Cyan).height(40.dp))
        Text(text = "hola 2", modifier = Modifier.background(Color.Green).height(40.dp))
        Text(text = "hola 3", modifier = Modifier.background(Color.Magenta).height(40.dp))
        Text(text = "hola 4", modifier = Modifier.background(Color.Yellow).height(40.dp))
    }
}
