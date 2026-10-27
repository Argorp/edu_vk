package com.example.edu_vk.domain.repository

import com.example.edu_vk.domain.model.App

interface AppRepository {
    fun getAllApps(): List<App>
    fun getAppById(id: Int): App?
}