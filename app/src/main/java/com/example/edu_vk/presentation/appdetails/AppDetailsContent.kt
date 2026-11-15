package com.example.edu_vk.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.edu_vk.domain.model.App

@Composable
fun AppDetailsContent(
    content: AppDetailsState.Content,
    showcaseApps: List<App>,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onDeveloperClick: () -> Unit,
    onShowcaseAppClick: (String) -> Unit,
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
            app = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
            onLogoClick = onLogoClick
        )

        Spacer(Modifier.height(10.dp))
        InstallButton(
            installState = content.installState,
            onClick = onInstallClick,
            // TODO(поменять задний фон кнопки)
            modifier = Modifier.background(color = Color(255, 255, 200))
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
        ShowcaseBlock(
            apps = showcaseApps,
            onAppClick = onShowcaseAppClick,
            modifier = Modifier)
    }
}

@Composable
fun InstallButton(
    installState: InstallState,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(onClick = onClick, modifier = modifier) {
        when (installState) {
            is InstallState.NotInstalled -> Text("Установить")
            is InstallState.Installing -> Text("Отменить (${installState.progress}%)")
            is InstallState.Installed -> Text("Открыть")
        }
    }
}