package com.example.edu_vk.data.mapper

import com.example.edu_vk.data.dto.AppDto
import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.model.Category

fun AppDto.toDomain() : App {
    return App(
        id = this.id,
        name = this.name,
        developer = this.developer,
        shortDescription = this.shortDescription,
        fullDescription = this.fullDescription,
        category = transfer(this.category),
        ageRating = this.ageRating,
        size = this.size,
        iconName = this.iconName,
    )
}

private fun transfer(categoryString: String): Category {
    return when (categoryString) {
        "Социальные" -> Category.SOCIAL
        "Фото и видео" -> Category.PHOTOGRAPHY
        "Медиа" -> Category.MUSIC
        "Навигация" -> Category.MAPS
        "Покупки" -> Category.SHOPPING
        "Инструменты" -> Category.UTILITIES
        "Работа" -> Category.PRODUCTIVITY
        "Связь" -> Category.SOCIAL
        "Система" -> Category.SETTINGS
        else -> Category.APP
    }
}