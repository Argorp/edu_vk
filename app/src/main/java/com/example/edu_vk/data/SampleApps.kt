package com.example.edu_vk.data

import com.example.edu_vk.model.AppInfo
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Email

val samplesApp = listOf(
    AppInfo(1,
        Icons.AutoMirrored.Filled.Chat, "Мессенджер", "Быстрый обмен сообщениями", "Социальные"),
    AppInfo(2, Icons.Default.CameraAlt, "Камера Pro", "Съёмка в 4K с фильтрами", "Фото и видео"),
    AppInfo(3, Icons.Default.MusicNote, "Музыка", "Стриминг и локальная коллекция", "Медиа"),
    AppInfo(4, Icons.Default.Map, "Карты", "Навигация и пробки онлайн", "Навигация"),
    AppInfo(5, Icons.Default.ShoppingCart, "Маркет", "Покупки и доставка", "Покупки"),
    AppInfo(6, Icons.Default.Calculate, "Калькулятор", "Инженерный и валютный", "Инструменты"),
    AppInfo(7, Icons.Default.Email, "Почта", "Единый почтовый клиент", "Работа")
)