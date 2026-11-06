package com.example.edu_vk.domain.repository

import com.example.edu_vk.data.mapper.toDomain
import com.example.edu_vk.data.source.remote.Api
import com.example.edu_vk.domain.model.App
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val apiService: Api
) : AppRepository {

    override suspend fun getAllApps(): List<App> {
        return apiService.getCatalog().map { it.toDomain() }
    }

    override suspend fun getAppById(id: String): App? {
        // TODO(Заглушка)
        return getAllApps().find { it.id == id }
    }
}