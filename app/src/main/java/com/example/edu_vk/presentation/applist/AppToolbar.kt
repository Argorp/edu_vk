package com.example.edu_vk.presentation.applist

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    onLogoClick: () -> Unit
) {
    TopAppBar(
        title = { Text("Список приложений") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Apps,
                contentDescription = "Иконка приложения",
                modifier = Modifier.clickable { onLogoClick() }
                )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}