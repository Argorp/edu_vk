package com.example.edu_vk.presentation.appdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.edu_vk.R

@Composable
fun AppDescription(
    shortDescription: String,
    fullDescription: String,
    collapsed: Boolean,
    onReadMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    android.util.Log.d("Expand", "AppDescription: collapsed=$collapsed, short=${shortDescription.take(20)}, full=${fullDescription.take(20)}")
    Column(modifier) {
        Text(text = stringResource(R.string.app_details_description))
        Spacer(Modifier.height(8.dp))
        Text(
            text = if (collapsed) shortDescription else fullDescription,
            maxLines = if (collapsed) 3 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis,
        )
        if (collapsed) {
            TextButton(
                onClick = onReadMoreClick,
                contentPadding = PaddingValues(horizontal = 0.dp),
                // TODO: Добавить текст для раскрытия по кнопке Больше
            ) {
                Text(
                    text = stringResource(R.string.app_details_read_more),
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}