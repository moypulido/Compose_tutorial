package com.example.compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.compose_tutorial.Animations.MyInfiniteTransition
import com.example.compose_tutorial.ui.theme.Compose_TutorialTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Compose_TutorialTheme {
//                MyScaffold()
//                NavigationWrapper()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyInfiniteTransition(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
