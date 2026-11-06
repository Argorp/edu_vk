package com.example.edu_vk.data.mapper

import com.example.edu_vk.data.dto.CatalogResponseDto
import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.model.Category

fun CatalogResponseDto.toDomain(): App = App(
    id = id,
    name = name,
    developer = "Кто-то", // TODO()
    shortDescription = description,
    fullDescription = "",
    category = mapCategory(category),
    ageRating = 12, // TODO()
    size = 42.0f, // TODO()
    iconUrl = iconUrl
)

private fun mapCategory(categoryString: String): Category {
    return when (categoryString) {
        "Производительность" -> Category.PRODUCTIVITY
        "Здоровье и фитнес" -> Category.HEALTH
        "Фото и видео" -> Category.PHOTOGRAPHY
        "Еда и напитки" -> Category.FOOD
        "Образование" -> Category.EDUCATION
        "Образ жизни" -> Category.APP
        "Шопинг" -> Category.SHOPPING
        "Новости" -> Category.NEWS
        "Финансы" -> Category.FINANCE
        "Навигация" -> Category.MAPS
        "Общение" -> Category.SOCIAL
        "Бизнес" -> Category.BUSINESS
        "Погода" -> Category.APP
        "Книги и справочники" -> Category.BOOKS
        "Музыка" -> Category.MUSIC
        "Утилиты" -> Category.UTILITIES
        else -> Category.APP
    }
}