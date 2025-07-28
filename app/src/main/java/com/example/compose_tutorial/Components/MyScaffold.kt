package com.example.compose_tutorial.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddReaction
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.AddToDrive
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MyScaffold(
    modifier: Modifier = Modifier
) {
    val drawableState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackbarHostSate = remember { SnackbarHostState() }

    val scope: CoroutineScope = rememberCoroutineScope()

    MyModalDrawer(drawableState = drawableState) {
        Scaffold(
            topBar = {
                MyTopAppBar {
                    scope.launch {
                        if (drawableState.isClosed) {
                            drawableState.open()
                        } else {
                            drawableState.close()
                        }
                    }
                } // validate the drawer state and toggle it
            },
            bottomBar = { MyNavigationBar() },
            snackbarHost = { SnackbarHost(hostState = snackbarHostSate) },
            floatingActionButton = {
                MyFloatingActionButton(
                    onClick = {
                        scope.launch {
                            snackbarHostSate.showSnackbar(
                                message = "Floating Action Button Clicked",
                                actionLabel = "Dismiss"
                            )
                        }
                    }
                )
            }, // provide a floating action button and handle its click
            modifier = modifier
                .fillMaxSize()
                .border(1.dp, Color.Red) // apply a border to the scaffold and fill the max size
        ) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .border(1.dp, Color.Blue)
            ) {
                Text(
                    text = "Snackbar Example",
                    modifier = Modifier
                        .border(1.dp, Color.Green)
                        .clickable(
                            onClick = {
                                scope.launch {
                                    val snackbarResult = snackbarHostSate.showSnackbar(
                                        message = "Hello from Scaffold!",
                                        actionLabel = "Dismiss",
                                    )
                                    when (snackbarResult) {
                                        SnackbarResult.Dismissed -> {
                                            // Handle the dismissed case
                                        }

                                        SnackbarResult.ActionPerformed -> {
                                            // Handle the action performed case
                                        }
                                    }
                                }
                            }
                        )
                        .padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun MyModalDrawer(
    modifier: Modifier = Modifier,
    drawableState: DrawerState,
    content: @Composable () -> Unit = {}
) {
    val scope: CoroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawableState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer(
                    text = "Home",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AddToDrive,
                            contentDescription = "Home Icon",
                            modifier = Modifier.padding(8.dp)
                        )
                    },
                    notification = 5
                )
                MyNavigationDrawer(
                    text = "Profile",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AddReaction,
                            contentDescription = "Profile Icon",
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable(
                                    onClick = {
                                        scope.launch {
                                            drawableState.close() // close the drawer when profile is clicked
                                        }
                                    }
                                )
                        )
                    },
                    notification = 2
                )
                MyNavigationDrawer(
                    text = "Settings",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AddTask,
                            contentDescription = "Settings Icon",
                            modifier = Modifier.padding(8.dp)
                        )
                    },
                    notification = 0
                )
            }
        },
    ) {
        content()
    }

}

@Composable
fun MyNavigationDrawer(
    text: String = "Navigation Item",
    icon: @Composable () -> Unit = {},
    notification: Int = 0
) {
    NavigationDrawerItem(
        shape = RectangleShape,
        label = { Text(text = text) },
        selected = false,
        onClick = {},
        icon = {
            icon()
        },
        badge = {
            Badge { Text("$notification") }
        },
        modifier = Modifier
            .padding(8.dp)
            .border(
                shape = RectangleShape,
                width = 1.dp,
                color = Color.Magenta
            )
    )
}


@Composable
fun MyNavigationBar() {
    NavigationBar(
    ) {
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.AddToDrive,
                    contentDescription = "Apps Icon",
                    modifier = Modifier.padding(8.dp)
                )
            },
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.BarChart,
                    contentDescription = "Apps Icon",
                    modifier = Modifier.padding(8.dp)
                )
            },
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.AddTask,
                    contentDescription = "Apps Icon",
                    modifier = Modifier.padding(8.dp)
                )
            },
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.AddReaction,
                    contentDescription = "Apps Icon",
                    modifier = Modifier.padding(8.dp)
                )
            },
        )
    }
}

@Composable
fun MyFloatingActionButton(onClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .padding(18.dp)
            .border(1.dp, Color.Magenta)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(OnNavigationIconClick: () -> Unit = {}) {
    TopAppBar(
        title = { Text("My Top App Bar") },
//        expandedHeight = 50.dp,
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Apps,
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .padding(8.dp)
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Action Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        onClick = { OnNavigationIconClick() }
                    )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.LightGray,
            titleContentColor = Color.Black,
            actionIconContentColor = Color.Black
        ),
        modifier = Modifier
            .border(1.dp, Color.Magenta)
    )
}

