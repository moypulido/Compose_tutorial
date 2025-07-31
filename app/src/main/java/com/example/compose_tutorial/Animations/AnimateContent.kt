package com.example.compose_tutorial.Animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimateContent(
    modifier: Modifier = Modifier,
) {
    var number: Int by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 48.dp)
    ) {
        Button(
            onClick = { number++ }
        ) {
            Text("Increment")
        }
        Spacer(modifier = Modifier.padding(16.dp))

        AnimatedContent(
            targetState = number,
            transitionSpec = {
                (slideInVertically(
                    initialOffsetY = { height -> height },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300)))
                    .togetherWith(
                        slideOutVertically(
                            targetOffsetY = { height -> -height },
                            animationSpec = tween(300)
                        ) + fadeOut(animationSpec = tween(300))
                    )
            }
        ) { targetNumber ->
            Text(
                text = "$targetNumber",
                modifier = Modifier.padding(16.dp)
            )
        }

    }
}