package com.example.compose_tutorial.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MyTextFieldParent(modifier: Modifier = Modifier) {
    var text: String by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        MyTextField(
            text = text,
            onValueChange = { value -> text = value }
        )
        MyAdvanceTextField(
            text = text,
            onValueChange = { value -> text = value }
        )
        ArisAdvanceTextField(
            text = text,
            onValueChange = { value -> text = value }
        )
        MyOutlinnerTextField(
            text = text,
            onValueChange = { value -> text = value }
        )
    }
}

@Composable
fun MyTextField(text: String, onValueChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = { value -> onValueChange(value) },
        readOnly = true
    )
}

@Composable
fun MyAdvanceTextField(text: String, onValueChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = { value ->
            onValueChange(value.replace("a", ""))
        },
    )
}

@Composable
fun ArisAdvanceTextField(
    text: String,
    onValueChange: (String) -> Unit,
    styleHeader: TextStyle = MaterialTheme.typography.labelSmall,
    styleText: TextStyle = MaterialTheme.typography.headlineSmall
) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    TextField(
        value = text,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = {
            Text(
                text = "Enter password",
                style = styleHeader
            )
        },
        textStyle = styleText,
        visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(
                onClick = { passwordHidden = !passwordHidden }
            ) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description =
                    if (passwordHidden) "Show password" else "Hide password"

                Icon(
                    imageVector = visibilityIcon,
                    contentDescription = description
                )
            }
        }
    )
}

@Composable
fun MyOutlinnerTextField(
    text: String,
    onValueChange: (String) -> Unit,
    styleHeader: TextStyle = MaterialTheme.typography.labelSmall,
    styleText: TextStyle = MaterialTheme.typography.headlineSmall
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = {
            Text(
                text = "Enter password",
                style = styleHeader
            )

        },
        textStyle = styleText,
    )
}