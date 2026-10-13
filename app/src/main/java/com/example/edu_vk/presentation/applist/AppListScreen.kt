package com.example.edu_vk.presentation.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.edu_vk.data.samplesApp

@Composable
fun AppListScreen(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Scaffold(
        topBar = { AppToolbar() },
        modifier = modifier.fillMaxSize(),
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = innerPadding
        ) {
            items(samplesApp, key = { it.id }) { app ->
                AppListItem(
                    app,
                    onClick = onClick,
                    modifier = modifier
                )
            }
        }
    }
}