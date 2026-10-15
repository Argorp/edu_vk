package com.example.edu_vk.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.edu_vk.data.samplesApp
import com.example.edu_vk.model.*

@Composable
fun AppDetailsScreen(
    appId: Int,
    onBackClick: () -> Unit,
    onShowcaseAppClick: (Int) -> Unit,
) {
    val allApps: List<AppInfo> = (samplesApp + showcaseApps).distinctBy { it.id }
    val currentApp: AppInfo? = allApps.find { it.id == appId }

    var contentState by remember(appId) {
        mutableStateOf<AppDetailsState>(buildContent(currentApp))
    }

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
    ) { contentPadding ->
        when (val state = contentState) {
            is AppDetailsState.Content -> {
                AppDetailsContent(
                    content = state,
                    onBackClick = onBackClick,
                    onShareClick = { },
                    onInstallClick = { },
                    onReadMoreClick = {
                        contentState = state.copy(descriptionCollapsed = false)
                    },
                    onDeveloperClick = { },
                    onSimilarAppDownloadClick = { },
                    onShowcaseAppClick = onShowcaseAppClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Error -> {
                Text(
                    "Приложение не найдено",
                    modifier = Modifier.fillMaxSize().padding(contentPadding).padding(16.dp),
                )
            }
            is AppDetailsState.Loading -> {
                Text(
                    "Загрузка...",
                    modifier = Modifier.fillMaxSize().padding(contentPadding).padding(16.dp),
                )
            }
        }
    }
}

private fun buildContent(app: AppInfo?): AppDetailsState {
    if (app == null) return AppDetailsState.Error

    return AppDetailsState.Content(
        appDetails = AppDetails(
            id = app.id,
            name = app.name,
            developer = "Someone",
            shortDescription = app.shortDescription,
            fullDescription = app.fullDescription,
            icon = app.icon,
            category = app.category,
            ageRating = app.ageRating,
            size = app.size,
        ),
        descriptionCollapsed = true,
        similarApps = emptyList(),
    )
}