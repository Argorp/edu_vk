package com.example.edu_vk.presentation.applist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AppListScreen(
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val ratings by viewModel.ratings.collectAsState()
    val benchmarkResult by viewModel.benchmarkResult.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            if (event is AppListEvent.ShowSnackbar) {
                snackbarHostState.showSnackbar(event.message)
            }
        }
    }

    Scaffold(
        topBar = { AppToolbar(onLogoClick = { viewModel.onLogoClick() }) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier.fillMaxSize()
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {

            // Тесты
            if (state is AppListState.Content) {
                val apps = (state as AppListState.Content).apps
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = { viewModel.testPoslepovatelno(apps) }) {
                        Text("Последовательно")
                    }
                    Button(onClick = { viewModel.testPrallelno(apps) }) {
                        Text("Параллельно")
                    }
                }
                // Вывод времени выполнения
                benchmarkResult?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }


            when (val currentState = state) {
                is AppListState.Loading -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                is AppListState.Error -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Ошибка загрузки данных")
                    }
                }
                is AppListState.Content -> {
                    LazyColumn(modifier = Modifier.weight(1f)) {
                        items(currentState.apps, key = { it.id }) { app ->
                            AppListItem(
                                app = app,
                                rating = ratings[app.id],
                                onClick = { onAppClick(app.id) }
                            )
                        }
                    }
                }
            }
        }
    }
}