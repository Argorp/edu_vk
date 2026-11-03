package com.example.edu_vk.di

import com.example.edu_vk.domain.repository.AppRepository
import com.example.edu_vk.domain.repository.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAppRepository (
        impl: AppRepositoryImpl
    ): AppRepository
}