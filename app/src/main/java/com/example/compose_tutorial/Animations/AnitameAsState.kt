package com.example.compose_tutorial.Animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun FullAnimationAsState(modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }

    val animationColor by animateColorAsState(
        targetValue = if (isSelected) Color.Green else Color.Red,
        label = "Color Animation",
        animationSpec = androidx.compose.animation.core.spring(
            stiffness = androidx.compose.animation.core.Spring.DampingRatioMediumBouncy
        )
    )

    val animateSize by animateDpAsState(
        targetValue = if (isSelected) 300.dp else 150.dp,
        label = "Size Animation",
        animationSpec = androidx.compose.animation.core.spring(
            stiffness = androidx.compose.animation.core.Spring.DampingRatioMediumBouncy
        )
    )

    val animateOffSet by animateOffsetAsState(
        targetValue = if (isSelected) Offset(0f, 0f) else Offset(0f, 200f),
        label = "Offset Animation",
        animationSpec = androidx.compose.animation.core.spring(
            stiffness = androidx.compose.animation.core.Spring.DampingRatioMediumBouncy
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Spacer(modifier.height(60.dp))
        Button(
            onClick = {
                isSelected = !isSelected
            }
        ) {
            Text(if (isSelected) "Select" else "Unselect")
        }
        Spacer(modifier.height(20.dp))
        Box(
            modifier
                .offset {
                    IntOffset(
                        animateOffSet.x.roundToInt(),
                        animateOffSet.y.roundToInt()
                    )
                }
                .fillMaxWidth()
                .height(animateSize)
                .background(animationColor)
        )
    }
}