package com.example.edu_vk.model

import androidx.compose.ui.graphics.vector.ImageVector

data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val icon: ImageVector,
    val description: String,
)