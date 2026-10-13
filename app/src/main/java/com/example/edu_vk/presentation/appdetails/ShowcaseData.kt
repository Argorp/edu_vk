package com.example.edu_vk.presentation.appdetails

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.edu_vk.model.AppInfo

data class ShowcaseApp(
    val id: Int,
    val icon: ImageVector,
    val name: String,
    val opisanie: String,
    val category: String
)

val showcaseApps: List<AppInfo> = listOf(
    AppInfo(0, Icons.Default.Chair, "Мессенджер", "Быстрый обмен", "Соцсети"),
    AppInfo(1, Icons.Default.CameraAlt, "Камера Pro", "Съёмка 4K", "Фото"),
    AppInfo(2, Icons.Default.LibraryMusic, "Музыка", "Стриминг", "Медиа"),
    AppInfo(3, Icons.Default.Map, "Карты", "Навигация", "Навигация"),
    AppInfo(4, Icons.Default.Shop, "Маркет", "Покупки", "Покупки"),
    AppInfo(5, Icons.Default.Calculate, "Калькулятор", "Инженерный", "Утилиты"),
    AppInfo(6, Icons.Default.Email, "Почта", "Клиент", "Работа"),
    AppInfo(7, Icons.Default.Phone, "Телефон", "Звонки", "Связь"),
    AppInfo(8, Icons.Default.Settings, "Настройки", "Система", "Система")
)

val showcasePages: List<List<AppInfo>> = showcaseApps.chunked(3)