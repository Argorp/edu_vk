package com.example.edu_vk.domain.usecase

import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.repository.AppRepository
import javax.inject.Inject

class GetAppsUseCase @Inject constructor(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): List<App> {
        return repository.getAllApps()
    }
}