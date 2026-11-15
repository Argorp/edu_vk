package com.example.edu_vk.domain.repository

import com.example.edu_vk.data.mapper.toDomain
import com.example.edu_vk.data.source.remote.Api
import com.example.edu_vk.domain.model.App
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.system.measureTimeMillis

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

    override suspend fun Poslepovatelno(ids: List<String>): Pair<Map<String, Float>, Long> {
        val ratings = mutableMapOf<String, Float>()
        val time = measureTimeMillis {
            for (id in ids) {
                ratings[id] = apiService.getRating(id)
            }
        }
        return Pair(ratings, time)
    }

    override suspend fun Prallelno(ids: List<String>): Pair<Map<String, Float>, Long> {
        var ratings = emptyMap<String, Float>()
        val time = measureTimeMillis {
            ratings = coroutineScope {
                ids.map { id ->
                    async { id to apiService.getRating(id) }
                }.awaitAll().toMap()
            }
        }
        return Pair(ratings, time)
    }
}