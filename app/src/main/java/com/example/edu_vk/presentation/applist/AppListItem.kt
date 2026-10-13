package com.example.applist.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.edu_vk.model.AppInfo

@Composable
fun AppListItem(app: AppInfo) {
    ListItem(
        leadingContent = {
            Icon(
                imageVector = app.icon,
                contentDescription = app.name,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        },
        headlineContent = { Text(app.name, style = MaterialTheme.typography.titleMedium) },
        supportingContent = {
            Column {
                Text(
                    text = app.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = app.category,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 2.dp)
    )
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}