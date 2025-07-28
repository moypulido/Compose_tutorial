package com.example.compose_tutorial.Animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimationVisibility(modifier: Modifier = Modifier) {

    var isVisible by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Spacer(modifier.height(60.dp))
        Button(
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text(if (isVisible) "Hide" else "Show")
        }
        Spacer(modifier.height(20.dp))

        AnimatedVisibility(
            visible = isVisible,
//            enter = shrinkIn(),
//            exit = shrinkOut(),
        ) {
            Box(
                modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Red)
            )
        }
    }
}
