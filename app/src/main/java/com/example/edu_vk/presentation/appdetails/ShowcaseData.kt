package com.example.edu_vk.presentation.appdetails

import com.example.edu_vk.data.mapper.toDomain
import com.example.edu_vk.data.source.AppLocalDataSource.appsDto
import com.example.edu_vk.domain.model.App
val showcaseApps: List<App> = appsDto.map { it.toDomain() }
val showcasePages: List<List<App>> = showcaseApps.chunked(3)