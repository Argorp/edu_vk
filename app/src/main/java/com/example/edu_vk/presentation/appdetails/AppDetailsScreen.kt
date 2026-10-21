package com.example.edu_vk.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppDetailsScreen(
    appId: Int,
    onBackClick: () -> Unit,
    onShowcaseAppClick: (Int) -> Unit,
    viewModel: AppDetailsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(appId) {
        viewModel.load(appId)
    }

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
    ) { contentPadding ->
        when (val currentState = state) {
            is AppDetailsState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize().padding(contentPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is AppDetailsState.Error -> {
                Text(
                    "Приложение не найдено",
                    modifier = Modifier.fillMaxSize().padding(contentPadding).padding(16.dp),
                )
            }

            is AppDetailsState.Content -> {
                AppDetailsContent(
                    content = currentState,
                    onBackClick = onBackClick,
                    onShareClick = { },
                    onInstallClick = { },
                    onReadMoreClick = { viewModel.expandDescription() },
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
    }
}