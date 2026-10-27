package com.example.edu_vk.data.dto

data class AppDto (
    val id: Int,
    val name: String,
    val developer: String,
    val shortDescription: String,
    val fullDescription: String,
    val category: String,
    val ageRating: Int,
    val size: Float,
    val iconName: String
)