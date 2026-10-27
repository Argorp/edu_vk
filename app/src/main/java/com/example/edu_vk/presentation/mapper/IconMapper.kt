package com.example.edu_vk.presentation.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

fun getIconByName(s: String) : ImageVector {
    return when (s) {
        "Chat" -> Icons.AutoMirrored.Filled.Chat
        "Camera" -> Icons.Default.CameraAlt
        "Music" -> Icons.Default.MusicNote
        "Map" -> Icons.Default.Map
        "Shopping" -> Icons.Default.ShoppingCart
        "Calculate" -> Icons.Default.Calculate
        "Email" -> Icons.Default.Email
        "Phone" -> Icons.Default.Phone
        "Settings" -> Icons.Default.Settings
        else -> Icons.Default.Apps
    }
}