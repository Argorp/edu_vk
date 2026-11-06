package com.example.edu_vk.presentation.applist

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppsOutage
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    onLogoClick: () -> Unit
) {
    TopAppBar(
        title = { Text("Список приложений") },
        navigationIcon = {
            IconButton(onLogoClick) {
                Icon(
                    imageVector = Icons.Default.AppsOutage,
                    contentDescription = "Ты всё равно это не увидишь..."
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}