package com.example.compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.compose_tutorial.Navigation.NavigationWrapper
import com.example.compose_tutorial.ui.theme.Compose_TutorialTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Compose_TutorialTheme {
//                MyScaffold()
                NavigationWrapper()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MyInteractionSource(modifier = Modifier.padding(innerPadding))
//                }
            }
        }
    }
}
