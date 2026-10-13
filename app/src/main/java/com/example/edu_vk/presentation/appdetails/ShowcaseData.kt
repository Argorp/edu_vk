package com.example.edu_vk.presentation.appdetails

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class ShowcaseApp(
    val id: Int,
    val icon: ImageVector,
    val name: String,
    val opisanie: String,
    val category: String
)

val showcaseApps: List<ShowcaseApp> = listOf(
    ShowcaseApp(0, Icons.Default.Chair, "Мессенджер", "Быстрый обмен", "Соцсети"),
    ShowcaseApp(1, Icons.Default.CameraAlt, "Камера Pro", "Съёмка 4K", "Фото"),
    ShowcaseApp(2, Icons.Default.LibraryMusic, "Музыка", "Стриминг", "Медиа"),
    ShowcaseApp(3, Icons.Default.Map, "Карты", "Навигация", "Навигация"),
    ShowcaseApp(4, Icons.Default.Shop, "Маркет", "Покупки", "Покупки"),
    ShowcaseApp(5, Icons.Default.Calculate, "Калькулятор", "Инженерный", "Утилиты"),
    ShowcaseApp(6, Icons.Default.Email, "Почта", "Клиент", "Работа"),
    ShowcaseApp(7, Icons.Default.Phone, "Телефон", "Звонки", "Связь"),
    ShowcaseApp(8, Icons.Default.Settings, "Настройки", "Система", "Система")
)

val showcasePages: List<List<ShowcaseApp>> = showcaseApps.chunked(3)