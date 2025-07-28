package com.example.compose_tutorial.Components

//import androidx.compose.material3.ExposedDropdownMenuBoxDefaults
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

@Composable
fun MyDropdown(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        MyDropdownItem()
        Spacer(modifier.size(1.dp))
        MyDropdownMenu()
        Spacer(modifier.size(1.dp))
        MyExportedDropdownMenu()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExportedDropdownMenu() {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    var chose by rememberSaveable { mutableStateOf("Default Item") }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded },
    ) {
        TextField(
            value = chose,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(text = "Select Item")
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
                .border(1.dp, Color.Red),
            trailingIcon = {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            }
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier
                .border(1.dp, Color.Red)
                .width(200.dp),
            offset = DpOffset(
                x = 0.dp,
                y = 0.dp
            ),
            properties = PopupProperties(
                focusable = true,
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            MyDropdownItem("Item 1", onClick = {
                isExpanded = false
                chose = "Item 1"
            })
            MyDropdownItem("Item 2", onClick = {
                isExpanded = false
                chose = "Item 2"
            })
            MyDropdownItem("Item 3", onClick = {
                isExpanded = false
                chose = "Item 3"
            })
        }
    }

}

@Composable
fun MyDropdownMenu() {

    var isExpanded by rememberSaveable { mutableStateOf(false) }
    var Chose by rememberSaveable { mutableStateOf("Default Item") }
    var buttonWidth by rememberSaveable { mutableStateOf(0) }
    val density = LocalDensity.current

    Box(modifier = Modifier) {
        Button(
            modifier = Modifier
                .border(1.dp, Color.Red)
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    buttonWidth = coordinates.size.width
                },
            shape = RoundedCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White,
            ),
            onClick = { isExpanded = true },
        ) {
            Text(text = Chose)
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier
                .border(1.dp, Color.Red)
                .width(with(density) { buttonWidth.toDp() }),
//                .height(400.dp),
            offset = DpOffset(
                x = 0.dp,
                y = -30.dp
            ),
            properties = PopupProperties(
                focusable = true,
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            MyDropdownItem("Item 1", onClick = {
                isExpanded = false
                Chose = "Item 1"
            })
            MyDropdownItem("Item 2", onClick = {
                isExpanded = false
                Chose = "Item 2"
            })
            MyDropdownItem("Item 3", onClick = {
                isExpanded = false
                Chose = "Item 3"
            })
            MyDropdownItem("Item 4", onClick = {
                isExpanded = false
                Chose = "Item 4"
            })
        }
    }

}

@Composable
fun MyDropdownItem(text: String = "Default Item", onClick: () -> Unit = {}) {
    DropdownMenuItem(
        modifier = Modifier.border(1.dp, Color.Red),
        text = { Text(text = text) },
        onClick = { onClick() },
        contentPadding = PaddingValues(16.dp)
    )
}