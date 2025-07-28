package com.example.compose_tutorial.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp


@Composable
fun MyControlComponent(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(true) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        MySwitch()
        MyCheckBox()
        MyCheckBoxWithText(
            text = "Check me",
            checkBoxState = isChecked,
            onCheckedChange = { isChecked = it }
        )
        MyTriStateCheckBox()
        MyRadioButtons()
    }
}

@Composable
fun MyRadioButtons() {
    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .border(1.dp, Color.Gray)
            .padding(16.dp),
    ) {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(text = option)
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option }
                )
            }
        }
    }
}

@Composable
fun MySwitch() {
    var isChecked by remember { mutableStateOf(true) }
    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        thumbContent = {
            if (isChecked) {
                Text("On")
            } else {
                Text("Off")
            }
        },

//        enabled = false
    )
}

@Composable
fun MyCheckBox() {
    var isChecked by remember { mutableStateOf(true) }
    Checkbox(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        colors = androidx.compose.material3.CheckboxDefaults.colors(
            checkedColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
            uncheckedColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
        )
    )
}

@Composable
fun MyCheckBoxWithText(
    text: String,
    checkBoxState: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(text = text)
        Checkbox(
            checked = checkBoxState,
            onCheckedChange = { onCheckedChange(it) },
            colors = androidx.compose.material3.CheckboxDefaults.colors(
                checkedColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                uncheckedColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
            )
        )
    }
}

@Composable
fun MyTriStateCheckBox() {

    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    val parent = when {
        child1 && child2 -> ToggleableState.On
        else -> ToggleableState.Off
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.border(1.dp, Color.Gray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = "Tri-State CheckBox 1")
            TriStateCheckbox(
                state = parent,
                onClick = {
                    val newState = parent != ToggleableState.On
                    child1 = newState
                    child2 = newState
                }
            )
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 24.dp)
        ) {
            Text(text = "Tri-State CheckBox 1")
            Checkbox(
                checked = child1,
                onCheckedChange = {
                    child1 = it
                }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 24.dp)
        ) {
            Text(text = "Tri-State CheckBox 2")
            Checkbox(
                checked = child2,
                onCheckedChange = {
                    child2 = it
                },
            )
        }
    }
}
