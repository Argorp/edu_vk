package com.example.edu_vk.presentation.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppListScreen(
    onAppClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = viewModel()
) {
    val apps by viewModel.apps.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    // Слушаем события для показа Snackbar
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is AppListEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Scaffold(
        topBar = {
            AppToolbar(onLogoClick = { viewModel.onLogoClick() })
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier.fillMaxSize()
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding
        ) {
            items(apps, key = { it.id }) { app ->
                AppListItem(
                    app = app,
                    onClick = { onAppClick(app.id) }
                )
            }
        }
    }
}