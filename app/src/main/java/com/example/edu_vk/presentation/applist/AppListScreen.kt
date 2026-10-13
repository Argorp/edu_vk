package com.example.applist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.edu_vk.data.samplesApp
import com.example.edu_vk.presentation.applist.AppToolbar

@Composable
fun AppListScreen() {
    Scaffold(
        topBar = { AppToolbar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding
        ) {
            items(samplesApp, key = { it.id }) { app ->
                AppListItem(app)
            }
        }
    }
}