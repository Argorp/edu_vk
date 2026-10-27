package com.example.edu_vk.domain.model

data class App (
    val id: Int,
    val name: String,
    val developer: String,
    val shortDescription: String,
    val fullDescription: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconName: String
)