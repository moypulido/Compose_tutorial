package com.example.compose_tutorial.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyDialogComponents(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        MyDialogComponent()
        MyDatePickerComponent()
        MyTimePickerComponent()
        MyCustomDialogComponent()
    }
}

@Composable
fun MyCustomDialogComponent() {

    var isCustomDialogOpen by rememberSaveable { mutableStateOf(false) }

    Button(
        onClick = { isCustomDialogOpen = true }
    ) {
        Text(text = "Open Custom Dialog")
    }

    if (isCustomDialogOpen) {
        Dialog(
            onDismissRequest = { isCustomDialogOpen = false },
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(180.dp)
                    .border(1.dp, Color.Red)
                    .background(Color.Black)
            ) {
                Text(
                    text = "This is a custom dialog",
                    modifier = Modifier
                        .padding(16.dp)
                        .border(1.dp, Color.Blue)
                )
                Button(
                    onClick = { isCustomDialogOpen = false },
                    modifier = Modifier
                        .border(1.dp, Color.Red)

                ) {
                    Text(text = "Close")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePickerComponent() {
    var isTimePickerOpen by rememberSaveable { mutableStateOf(false) }
    val timePickerState = rememberTimePickerState()

    Button(
        onClick = { isTimePickerOpen = true }
    ) {
        Text(text = "Open time Picker")
    }

    if (isTimePickerOpen) {
        AlertDialog(
            onDismissRequest = { isTimePickerOpen = false },
            confirmButton = {
                Button(onClick = { isTimePickerOpen = false }) {
                    Text("OK")
                }
            },
            text = {
                TimePicker(
                    state = timePickerState,
                )
            },
            modifier = Modifier.border(1.dp, Color.Red)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerComponent() {
    val datePickerState = rememberDatePickerState()
    var isDatePickerOpen by rememberSaveable { mutableStateOf(false) }

    Button(
        onClick = { isDatePickerOpen = true }
    ) {
        Text(text = "Open Date Picker")
    }

    if (isDatePickerOpen) {
        AlertDialog(
            onDismissRequest = { isDatePickerOpen = false },
            confirmButton = {
                Button(onClick = { isDatePickerOpen = false }) {
                    Text("OK")
                }
            },
            text = {
                DatePicker(state = datePickerState)
            },
            modifier = Modifier.border(1.dp, Color.Red)
        )
    }

}


@Composable
fun MyDialogComponent() {
    var isDialogOpen by rememberSaveable { mutableStateOf(false) }
    Button(
        onClick = { isDialogOpen = true }
    ) {
        Text(text = "Open Dialog")
    }

    if (isDialogOpen) {
        MyDialog(
            onDismissRequest = { isDialogOpen = false }
        )
    }
}

@Composable
fun MyDialog(onDismissRequest: () -> Unit = {}) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(onClick = onDismissRequest) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text("Cancel")
            }
        },
        text = {
            Text("This is a dialog")
        },
        title = {
            Text("Dialog Title")
        },
        properties = DialogProperties(
            dismissOnClickOutside = false,
            dismissOnBackPress = false,
        ),
        modifier = Modifier
            .border(1.dp, Color.Red)
    )
}



