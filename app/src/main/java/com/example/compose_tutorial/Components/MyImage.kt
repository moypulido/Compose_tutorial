package com.example.compose_tutorial.Components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.compose_tutorial.R

@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(27.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyImageComponent()
            MyNetworkImage()
            MyIcon()
        }
    }
}

@Composable
fun MyImageComponent() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "My Image",
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .border(width = 5.dp, color = Color.Red, shape = RoundedCornerShape(50))
            .border(width = 10.dp, color = Color.Blue, shape = RoundedCornerShape(50))
            .border(width = 15.dp, color = Color.Green, shape = RoundedCornerShape(50))
            .border(width = 20.dp, color = Color.Yellow, shape = RoundedCornerShape(50))
            .border(width = 25.dp, color = Color.Magenta, shape = RoundedCornerShape(50))
            .border(width = 30.dp, color = Color.Cyan, shape = RoundedCornerShape(50))
    )
}

@Composable
fun MyNetworkImage() {
    AsyncImage(
        model = "https://picsum.photos/200/300",
        contentDescription = "Network Image",
        modifier = Modifier.size(200.dp),
        onError = {
            Log.i("moises", "Error loading image: ${it.result.throwable.message}")
        }
    )
}

@Composable
fun MyIcon() {
    Icon(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "My Icon",
        tint = Color.Red,
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(50))
            .border(width = 5.dp, color = Color.Red, shape = RoundedCornerShape(50))
    )
}