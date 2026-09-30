package com.example.edu_vk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*var text by remember { mutableStateOf("") }
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = text,
                    onValueChange = {text = it},
                    label = {Text("Введите текст")},
                    modifier = Modifier.fillMaxWidth()
                )
            }*/
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = {Text("Введите текст")},
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (text.trim().isEmpty()) {
                    Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                val intent = Intent(context, SecondActivity::class.java).apply {
                    putExtra("EXTRA_TEXT", text)
                }
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Открыть вторую Activity")
        }
        Button(
            // TODO: добавить возможность переводить 8... на +7...
            onClick = {
                val fix = text.trim()
                if (fix.isEmpty() || !fix.startsWith("+7")) {
                    Toast.makeText(context, "Введите корректный номер телефона", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = "tel:$fix".toUri()
                }
                if (dialIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(dialIntent)
                }
                else {
                    Toast.makeText(context, "Нет приложения для звонков", Toast.LENGTH_SHORT).show()
                }
                context.startActivity(dialIntent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Позвонить другу")
        }
    }
}