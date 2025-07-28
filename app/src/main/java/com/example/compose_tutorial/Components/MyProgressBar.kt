package com.example.compose_tutorial.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.compose_tutorial.R

@Composable
fun MyProgressBar(modifier: Modifier = Modifier) {
    var process by remember { mutableFloatStateOf(0.1f) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(27.dp),
        ) {
            MyCircularProgressBar()
            MyLinearProgressBar()
            Row {
                Button(onClick = { process -= 0.1f }) { Text("remove") }
                Spacer(modifier = Modifier.size(10.dp))
                Button(onClick = { process += 0.1f }) { Text("add") }
            }
            MyLinearProgressBarIndeterminate { process }

            MyLoadingLottie()
        }
    }
}

@Composable
fun MyCircularProgressBar() {
    CircularProgressIndicator(
        strokeWidth = 100.dp,
//        trackColor = androidx.compose.ui.graphics.Color.LightGray,
        strokeCap = androidx.compose.ui.graphics.StrokeCap.Butt,
        modifier = Modifier
            .size(200.dp)
    )
}

@Composable
fun MyLinearProgressBar() {
    LinearProgressIndicator(
        modifier = Modifier
            .height(20.dp),
//        trackColor = androidx.compose.ui.graphics.Color.LightGray,
        strokeCap = androidx.compose.ui.graphics.StrokeCap.Square,
    )
}

@Composable
fun MyLinearProgressBarIndeterminate(process: () -> Float) {
    LinearProgressIndicator(
        progress = { process() },
        modifier = Modifier
            .height(20.dp),
        trackColor = Color.Transparent,
        strokeCap = androidx.compose.ui.graphics.StrokeCap.Butt,
    )
}

@Composable
fun MyLoadingLottie() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loading_animation)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
    LottieAnimation(
        modifier = Modifier
            .border(1.dp, Color.Gray)
            .size(200.dp),
        composition = composition,
        progress = { progress }
    )
}