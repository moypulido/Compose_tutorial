package com.example.compose_tutorial.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySliders(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 60.dp, vertical = 20.dp)
    ) {
        MySlider()
        MyCustomSlider()
        MyRangeSlider()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCustomSlider() {
    val state = remember {
        SliderState(
            value = 50f,
            valueRange = 0f..100f,
            steps = 9,
            onValueChangeFinished = {
                // Handle value change finished
            }

        )
    }
    Text(
        text = "Custom Slider value: ${state.value}",
    )
    Slider(
        state = state,
        thumb = { state: SliderState ->
            Text(text = "${state.value.toInt()}")
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    var state: RangeSliderState = remember {
        RangeSliderState(
            activeRangeStart = 20f,
            activeRangeEnd = 100f,
            valueRange = 0f..100f,
        )
    }
    Text(
        text = "Range Slider value: ${state.valueRange}",
    )
    RangeSlider(
        state = state,
    )
}

@Composable
fun MySlider() {
    var myValue by remember { mutableFloatStateOf(0f) }
    Text(
        text = "Slider value: ${myValue}",
    )
    Slider(
        value = myValue,
        onValueChange = { myValue = it },
        colors = SliderDefaults.colors(
            thumbColor = androidx.compose.ui.graphics.Color.Blue,
            activeTrackColor = androidx.compose.ui.graphics.Color.Green,
            inactiveTrackColor = androidx.compose.ui.graphics.Color.LightGray
        )
    )

}