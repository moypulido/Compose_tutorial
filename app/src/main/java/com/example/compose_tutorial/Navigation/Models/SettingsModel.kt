package com.example.compose_tutorial.Navigation.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SettingsModel(
    val userId: String,
    val name: String,
    val theme: String
) : Parcelable