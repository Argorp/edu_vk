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
import com.example.edu_vk.model.Category

//TODO: заменить на логичный текст
val zaglushka = "Полноценный мессенджер с поддержкой текста, " +
        "голосовых сообщений, видеозвонков и обмена файлами до 2 ГБ. " +
        "Работает в фоне, имеет шифрование end-to-end и синхронизацию " +
        "между всеми вашими устройствами."

val samplesApp = listOf(
    AppInfo(1,
        Icons.AutoMirrored.Filled.Chat, "Мессенджер", "Быстрый обмен сообщениями", zaglushka,
        Category.SOCIAL),
    AppInfo(2, Icons.Default.CameraAlt, "Камера Pro", "Съёмка в 4K с фильтрами", zaglushka,
        Category.PHOTOGRAPHY),
    AppInfo(3, Icons.Default.MusicNote, "Музыка", "Стриминг и локальная коллекция", zaglushka,
        Category.MUSIC),
    AppInfo(4, Icons.Default.Map, "Карты", "Навигация и пробки онлайн", zaglushka, Category.MAPS),
    AppInfo(5, Icons.Default.ShoppingCart, "Маркет", "Покупки и доставка", zaglushka, Category.SHOPPING),
    AppInfo(6, Icons.Default.Calculate, "Калькулятор", "Инженерный и валютный", zaglushka, Category.UTILITIES),
    AppInfo(7, Icons.Default.Email, "Почта", "Единый почтовый клиент", zaglushka, Category.NEWS)
)