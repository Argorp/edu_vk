package com.example.edu_vk.model

import androidx.compose.ui.graphics.vector.ImageVector

data class AppInfo (
    val id: Int,
    val icon: ImageVector,
    val name: String,
    val description: String,
    val category: String
)