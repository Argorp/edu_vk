package com.example.edu_vk.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.edu_vk.model.AppDetails
import com.example.edu_vk.model.Category

@Composable
fun AppDetailsScreen(
    onBackClick: () -> Unit = {},
    onShowcaseAppClick: (String) -> Unit = {},
) {
    // ─── ФИКТИВНЫЕ ДАННЫЕ ДЛЯ ЭТАПА 2 ───
    val fakeContent = AppDetailsState.Content(
        appDetails = AppDetails(
            id = "1",
            name = "Тестовое приложение",
            developer = "Example Dev",
            description = "Описание для проверки вёрстки на этапе 2. " +
                    "Достаточно длинный текст, чтобы увидеть, как выглядит блок.",
            icon = Icons.Default.Apps,
            category = Category.BUSINESS,
            ageRating = 14,
            size = 145.2f
        ),
        descriptionCollapsed = true,
        similarApps = emptyList(),
    )

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
    ) { contentPadding ->
        AppDetailsContent(
            content = fakeContent,
            onBackClick = onBackClick,
            onShareClick = { },
            onInstallClick = { },
            onReadMoreClick = { },
            onDeveloperClick = { },
            onSimilarAppDownloadClick = { },
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(contentPadding),
        )
    }
}