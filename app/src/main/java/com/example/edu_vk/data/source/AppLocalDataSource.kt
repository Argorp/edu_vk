package com.example.edu_vk.data.source

import com.example.edu_vk.data.dto.AppDto

object AppLocalDataSource {
    val appsDto = listOf(
        AppDto(
            1,
            "Мессенджер",
            "Someone",
            "Быстрый обмен",
            "Полноценный мессенджер...",
            "Социальные",
            12,
            68.4f,
            "Chat"
        ),
        // TODO: перенести все данные из SampleApps.kt
        AppDto(2, "Камера Pro", "Someone", "Съёмка в 4K", "Профессиональное приложение...", "Фото и видео", 3, 124.8f, "Camera"),
        AppDto(3, "Музыка", "Someone", "Стриминг", "Музыкальный сервис...", "Медиа", 12, 92.1f, "Music"),
        AppDto(4, "Карты", "Someone", "Навигация", "Подробные карты...", "Навигация", 3, 156.7f, "Map"),
        AppDto(5, "Маркет", "Someone", "Покупки", "Единая площадка...", "Покупки", 12, 88.3f, "Shopping"),
        AppDto(6, "Калькулятор", "Someone", "Инженерный", "Мощный калькулятор...", "Инструменты", 3, 24.5f, "Calculate"),
        AppDto(7, "Почта", "Someone", "Клиент", "Удобный почтовый...", "Работа", 3, 47.9f, "Email"),
        AppDto(8, "Телефон", "Someone", "Звонки", "Стандартный сервис...", "Связь", 3, 36.2f, "Phone"),
        AppDto(9, "Настройки", "Someone", "Параметры", "Полный набор...", "Система", 3, 18.6f, "Settings")
    )
}