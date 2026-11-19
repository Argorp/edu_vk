package com.example.edu_vk

import com.example.edu_vk.data.dto.CatalogResponseDto
import com.example.edu_vk.data.mapper.toDomain
import com.example.edu_vk.data.mapper.toDto
import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.model.Category
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AppMapperTest {
    @Test
    fun `dto toDomain`() {
        val dto = CatalogResponseDto("1", "App", "Desc", "Производительность", "url")
        val domain = dto.toDomain()
        assertThat(domain.id).isEqualTo("1")
        assertThat(domain.name).isEqualTo("App")
        assertThat(domain.shortDescription).isEqualTo("Desc")
        assertThat(domain.category).isEqualTo(Category.PRODUCTIVITY)
    }

    @Test
    fun `dto toDomain maps Health category`() {
        val dto = CatalogResponseDto("1", "App", "Desc", "Здоровье и фитнес", "url")
        assertThat(dto.toDomain().category).isEqualTo(Category.HEALTH)
    }

    @Test
    fun `dto toDomain maps unknown category to APP`() {
        val dto = CatalogResponseDto("1", "App", "Desc", "UnknownCategory", "url")
        assertThat(dto.toDomain().category).isEqualTo(Category.APP)
    }

    @Test
    fun `domain toDto maps all fields correctly`() {
        val domain = App("1", "App", "Dev", "Short", "Full", Category.SHOPPING, 12, 10f, "url")
        val dto = domain.toDto()

        assertThat(dto.id).isEqualTo("1")
        assertThat(dto.name).isEqualTo("App")
        assertThat(dto.description).isEqualTo("Short")
        assertThat(dto.category).isEqualTo("Шопинг")
    }

    @Test
    fun `domain toDto maps MUSIC category to string`() {
        val domain = App("1", "App", "Dev", "Short", "Full", Category.MUSIC, 12, 10f, "url")
        assertThat(domain.toDto().category).isEqualTo("Музыка")
    }

    @Test
    fun `domain toDto maps UTILITIES category to string`() {
        val domain = App("1", "App", "Dev", "Short", "Full", Category.UTILITIES, 12, 10f, "url")
        assertThat(domain.toDto().category).isEqualTo("Утилиты")
    }

    @Test
    fun `double mapping returns original object`() {
        val original = CatalogResponseDto("1", "App", "Desc", "Бизнес", "url")
        val roundTrip = original.toDomain().toDto()
        assertThat(roundTrip).isEqualTo(original)
    }

    @Test
    fun `dto toDomain fills default values for missing data`() {
        val dto = CatalogResponseDto("1", "App", "Desc", "Бизнес", "url")
        val domain = dto.toDomain()
        // Кто-то !
        assertThat(domain.developer).isEqualTo("Неизвестный разработчик")
        assertThat(domain.fullDescription).isEmpty()
    }
}