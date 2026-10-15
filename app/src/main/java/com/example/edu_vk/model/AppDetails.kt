package com.example.edu_vk.model

import androidx.compose.ui.graphics.vector.ImageVector

data class AppDetails(
    val id: Int,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val shortDescription: String,
    val fullDescription: String,
    val size: Float,
    val icon: ImageVector,
)