package com.example.edu_vk

import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.model.Category
import com.example.edu_vk.domain.repository.AppRepository
import com.example.edu_vk.domain.usecase.GetAppsUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetAppsUseCaseTest {

    private var repository: AppRepository = mockk()
    private var useCase: GetAppsUseCase = GetAppsUseCase(repository)

    // 1. UseCase возвращает список из репозитория
    @Test
    fun `invoke returns list of apps from repository`() = runTest {
        val mockApps = listOf(App("1", "A", "D", "S", "F", Category.APP, 0, 0f, ""))
        coEvery { repository.getAllApps() } returns mockApps

        val result = useCase()

        assertThat(result).isEqualTo(mockApps)
    }

    // 2. UseCase возвращает пустой список
    @Test
    fun `invoke returns empty list if repository is empty`() = runTest {
        coEvery { repository.getAllApps() } returns emptyList()
        val result = useCase()
        assertThat(result).isEmpty()
    }

    // 3. UseCase пробрасывает ошибку репозитория
    @Test(expected = Exception::class)
    fun `invoke throws exception if repository throws`() = runTest {
        coEvery { repository.getAllApps() } throws Exception("Error")
        useCase()
    }

    // 4. Проверка, что вызывается именно нужный метод репозитория
    @Test
    fun `invoke calls getAllApps exactly once`() = runTest {
        coEvery { repository.getAllApps() } returns emptyList()
        useCase()
        io.mockk.coVerify(exactly = 1) { repository.getAllApps() }
    }

    // 5. Проверка типов возвращаемых данных
    @Test
    fun `invoke returns correct data types`() = runTest {
        val mockApps = listOf(App("1", "A", "D", "S", "F", Category.SOCIAL, 12, 10f, "url"))
        coEvery { repository.getAllApps() } returns mockApps

        val result = useCase()

        assertThat(result).isInstanceOf(List::class.java)
        assertThat(result[0]).isInstanceOf(App::class.java)
    }

    // 6. UseCase возвращает несколько элементов
    @Test
    fun `invoke returns multiple items`() = runTest {
        val mockApps = listOf(
            App("1", "A", "D", "S", "F", Category.APP, 0, 0f, ""),
            App("2", "B", "D", "S", "F", Category.GAME, 0, 0f, "")
        )
        coEvery { repository.getAllApps() } returns mockApps
        val result = useCase()
        assertThat(result).hasSize(2)
    }

    // 7. Проверка, что элементы не теряются
    @Test
    fun `invoke preserves order of apps`() = runTest {
        val mockApps = listOf(
            App("1", "First", "D", "S", "F", Category.APP, 0, 0f, ""),
            App("2", "Second", "D", "S", "F", Category.GAME, 0, 0f, "")
        )
        coEvery { repository.getAllApps() } returns mockApps
        val result = useCase()
        assertThat(result[0].name).isEqualTo("First")
        assertThat(result[1].name).isEqualTo("Second")
    }

    // 8. Проверка на неизменяемость списка при возврате
    @Test
    fun `invoke returns list that can be iterated safely`() = runTest {
        val mockApps = listOf(App("1", "A", "D", "S", "F", Category.APP, 0, 0f, ""))
        coEvery { repository.getAllApps() } returns mockApps
        val result = useCase()
        var count = 0
        for (app in result) { count++ }
        assertThat(count).isEqualTo(1)
    }
}
