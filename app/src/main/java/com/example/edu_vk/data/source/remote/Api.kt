package com.example.edu_vk.data.source.remote

import com.example.edu_vk.data.dto.CatalogResponseDto
import kotlinx.coroutines.delay
import retrofit2.http.GET

interface Api {
    @GET("catalog")
    suspend fun getCatalog(): List<CatalogResponseDto>

    suspend fun getRating(id: String): Float {
        delay(1500)
        return (30..50).random() / 10f
    }
}