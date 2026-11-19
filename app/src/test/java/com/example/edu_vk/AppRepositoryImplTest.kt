package com.example.edu_vk

import com.example.edu_vk.data.dto.CatalogResponseDto
import com.example.edu_vk.data.source.remote.Api
import com.example.edu_vk.domain.model.Category
import com.example.edu_vk.domain.repository.AppRepositoryImpl
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AppRepositoryImplTest {
    private var apiService: Api = mockk()
    private var repository: AppRepositoryImpl = AppRepositoryImpl(apiService)

    // 1. Успешная загрузка каталога
    @Test
    fun `getAllApps returns mapped list`() = runTest {
        val dtoList = listOf(CatalogResponseDto("1", "App", "Desc", "Шопинг", "url"))
        coEvery { apiService.getCatalog() } returns dtoList

        val result = repository.getAllApps()

        assertThat(result).hasSize(1)
        assertThat(result[0].id).isEqualTo("1")
        assertThat(result[0].category).isEqualTo(Category.SHOPPING)
    }

    // 2. Ошибка при загрузке каталога пробрасывается
    @Test(expected = Exception::class)
    fun `getAllApps throws exception on network error`() = runTest {
        coEvery { apiService.getCatalog() } throws Exception("Network Error")
        repository.getAllApps()
    }

    // 3. Пустой список обрабатывается корректно
    @Test
    fun `getAllApps returns empty list if api returns empty`() = runTest {
        coEvery { apiService.getCatalog() } returns emptyList()
        val result = repository.getAllApps()
        assertThat(result).isEmpty()
    }

    // 4. Успешное получение по ID (находит в каталоге)
    @Test
    fun `getAppById returns app if found in catalog`() = runTest {
        val dtoList = listOf(
            CatalogResponseDto("1", "App1", "Desc", "Шопинг", "url"),
            CatalogResponseDto("2", "App2", "Desc", "Музыка", "url")
        )
        coEvery { apiService.getCatalog() } returns dtoList

        val result = repository.getAppById("2")

        assertThat(result).isNotNull()
        assertThat(result?.name).isEqualTo("App2")
    }

    // 5. Получение по ID, если не найдено
    @Test
    fun `getAppById returns null if not found`() = runTest {
        coEvery { apiService.getCatalog() } returns emptyList()
        val result = repository.getAppById("999")
        assertThat(result).isNull()
    }

    // 6. Последовательная загрузка рейтингов (проверка размера)
    @Test
    fun `Poslepovatelno returns correct map`() = runTest {
        coEvery { apiService.getRating(any()) } returns 4.5f
        val ids = listOf("1", "2", "3")

        val (ratings, _) = repository.Poslepovatelno(ids)

        assertThat(ratings).hasSize(3)
        assertThat(ratings["1"]).isEqualTo(4.5f)
    }

    // 7. Параллельная загрузка рейтингов (проверка размера)
    @Test
    fun `Prallelno returns correct map`() = runTest {
        coEvery { apiService.getRating(any()) } returns 3.0f
        val ids = listOf("1", "2", "3", "4")

        val (ratings, _) = repository.Prallelno(ids)

        assertThat(ratings).hasSize(4)
        assertThat(ratings["4"]).isEqualTo(3.0f)
    }

    // 8. Параллельная загрузка не падает при пустом списке
    @Test
    fun `Prallelno handles empty list`() = runTest {
        val (ratings, _) = repository.Prallelno(emptyList())
        assertThat(ratings).isEmpty()
    }
}