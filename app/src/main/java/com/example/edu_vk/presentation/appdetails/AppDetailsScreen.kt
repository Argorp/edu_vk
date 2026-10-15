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
import com.example.edu_vk.data.samplesApp
import com.example.edu_vk.model.AppDetails
import com.example.edu_vk.model.AppInfo
import com.example.edu_vk.model.Category

@Composable
fun AppDetailsScreen(
    appId: Int,
    onBackClick: () -> Unit,
    onShowcaseAppClick: (Int) -> Unit,
) {
    //android.util.Log.d("AppDetails", "Открыт appId=$appId")
    val allApps: List<AppInfo> = (samplesApp + showcaseApps).distinctBy { it.id }
    val currentApp: AppInfo? = allApps.find {it.id == appId}

    val content: AppDetailsState = if (currentApp != null) {
        AppDetailsState.Content(
            appDetails = AppDetails(
                id = currentApp.id.toString(),
                name = currentApp.name,
                developer = "Someone",
                description = currentApp.description,
                icon = currentApp.icon,
                category = Category.ENTERTAINMENT,
                ageRating = currentApp.ageRating,
                size = currentApp.size
            ),
            descriptionCollapsed = true,
            similarApps = emptyList()
        )
    } else {
        AppDetailsState.Error
    }

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
    ) { contentPadding ->
        AppDetailsContent(
            content = content as AppDetailsState.Content,
            onBackClick = onBackClick,
            onShareClick = { },
            onInstallClick = { },
            onReadMoreClick = { },
            onDeveloperClick = { },
            onSimilarAppDownloadClick = { },
            onShowcaseAppClick = onShowcaseAppClick,
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(contentPadding),
        )
    }
}