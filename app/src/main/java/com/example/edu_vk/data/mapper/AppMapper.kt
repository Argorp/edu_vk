package com.example.edu_vk.data.mapper

import com.example.edu_vk.data.dto.CatalogResponseDto
import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.model.Category

fun CatalogResponseDto.toDomain(): App = App(
    id = id,
    name = name,
    developer = "Кто-то", // TODO(Исправить на возможных разрабов)
    shortDescription = description,
    fullDescription = "",
    category = mapCategory(category),
    ageRating = 12, // TODO(Добавить реальный рейтинг)
    size = 42.0f, // TODO(Добавить реальный размер приложений)
    iconUrl = iconUrl
)

fun App.toDto(): CatalogResponseDto = CatalogResponseDto(
    id = id,
    name = name,
    description = shortDescription,
    category = mapCategoryToString(category),
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

private fun mapCategoryToString(category: Category): String = when(category) {
    Category.PRODUCTIVITY -> "Производительность"
    Category.HEALTH -> "Здоровье и фитнес"
    Category.PHOTOGRAPHY -> "Фото и видео"
    Category.FOOD -> "Еда и напитки"
    Category.EDUCATION -> "Образование"
    Category.SHOPPING -> "Шопинг"
    Category.NEWS -> "Новости"
    Category.FINANCE -> "Финансы"
    Category.MAPS -> "Навигация"
    Category.SOCIAL -> "Общение"
    Category.BUSINESS -> "Бизнес"
    Category.BOOKS -> "Книги и справочники"
    Category.MUSIC -> "Музыка"
    Category.UTILITIES -> "Утилиты"
    else -> "Образ жизни"
}