package com.example.compose_tutorial.Navigation

import com.example.compose_tutorial.Navigation.Models.SettingsModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(
    val id: String
)

@Serializable
data class Settings(
    val settingsModel: SettingsModel
)