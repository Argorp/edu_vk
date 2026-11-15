package com.example.edu_vk.domain.repository

import com.example.edu_vk.domain.model.App

interface AppRepository {
    suspend fun getAllApps(): List<App>
    suspend fun getAppById(id: String): App?
    suspend fun Poslepovatelno(ids: List<String>): Pair<Map<String, Float>, Long>
    suspend fun Prallelno(ids: List<String>): Pair<Map<String, Float>, Long>
}