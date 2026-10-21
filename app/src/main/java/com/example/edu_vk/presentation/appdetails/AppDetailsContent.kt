package com.example.edu_vk.presentation.appdetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.edu_vk.model.SimilarApp

@Composable
fun AppDetailsContent(
    content: AppDetailsState.Content,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onDeveloperClick: () -> Unit,
    onShowcaseAppClick: (Int) -> Unit,
    onSimilarAppDownloadClick: (SimilarApp) -> Unit,
    onLogoClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val appDetails = content.appDetails
    val descriptionCollapsed = content.descriptionCollapsed

    Column(modifier.verticalScroll(rememberScrollState())) {
        AppDetailsToolbar(
            onBackClick = onBackClick,
            onShareClick = onShareClick,
        )

        Spacer(Modifier.height(8.dp))
        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
            onLogoClick = onLogoClick
        )

        Spacer(Modifier.height(12.dp))
        AppDescription(
            shortDescription = appDetails.shortDescription,
            fullDescription = appDetails.fullDescription,
            collapsed = descriptionCollapsed,
            onReadMoreClick = onReadMoreClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )

        Spacer(Modifier.height(16.dp))
        ShowcaseBlock(onAppClick = onShowcaseAppClick, modifier = Modifier)
    }
}