package com.example.edu_vk.presentation.applist

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar() {
    TopAppBar(
        title = { Text("Список приложений") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Apps,
                contentDescription = "Иконка приложения"
                )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}