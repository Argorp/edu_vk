package com.example.edu_vk.data.source.remote

import com.example.edu_vk.data.dto.CatalogResponseDto
import retrofit2.http.GET

interface Api {
    @GET("catalog")
    suspend fun getCatalog(): List<CatalogResponseDto>
}