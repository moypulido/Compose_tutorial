package com.example.compose_tutorial.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.compose_tutorial.Navigation.Examples.DetailScreen
import com.example.compose_tutorial.Navigation.Examples.HomeScreen
import com.example.compose_tutorial.Navigation.Examples.LoginScreen
import com.example.compose_tutorial.Navigation.Examples.SettingsScreen
import com.example.compose_tutorial.Navigation.Models.SettingsModel
import com.example.compose_tutorial.Navigation.Models.createGenericType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavigationGraph(innerPadding = innerPadding)
    }
}

@Composable
fun NavigationGraph(innerPadding: PaddingValues) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Login,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {

        composable<Login> {
            LoginScreen(onClickNavButton = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(
                onClickNavButton = {
                    navController.navigate(Login)
                },
                navigateToDetails = { id ->
                    navController.navigate(Detail(id = id))
                }
            )
        }

        composable<Detail> { navBackStackEntry ->
            val detail: Detail = navBackStackEntry.toRoute()
            DetailScreen(
                id = detail.id,
                onClickNavButton = { settingsModel ->
                    navController.navigate(route = Settings(settingsModel))
                },
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsModel>() to createGenericType<SettingsModel>())) { navBackStackEntry ->
            val settings: Settings = navBackStackEntry.toRoute()
            SettingsScreen(
                settingsModel = settings.settingsModel,
                onClickNavButton = {
                    navController.navigate(Login) {
                        popUpTo(Login) { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}