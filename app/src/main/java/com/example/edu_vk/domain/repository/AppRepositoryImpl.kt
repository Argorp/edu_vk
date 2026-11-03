package com.example.edu_vk.domain.repository

import com.example.edu_vk.data.mapper.toDomain
import com.example.edu_vk.data.source.AppLocalDataSource
import com.example.edu_vk.domain.model.App
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(): AppRepository {
    override fun getAllApps(): List<App> {
        return AppLocalDataSource.appsDto.map { it.toDomain() }
    }

    override fun getAppById(id: Int): App? {
        return getAllApps().find { it.id == id }
    }

}