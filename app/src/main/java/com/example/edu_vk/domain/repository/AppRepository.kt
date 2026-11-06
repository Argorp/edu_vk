package com.example.edu_vk.domain.repository

import com.example.edu_vk.domain.model.App

interface AppRepository {
    suspend fun getAllApps(): List<App>
    suspend fun getAppById(id: String): App?
}