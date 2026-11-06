package com.example.edu_vk.data.dto

import com.google.gson.annotations.SerializedName

data class CatalogResponseDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
    @SerializedName("iconUrl") val iconUrl: String
)