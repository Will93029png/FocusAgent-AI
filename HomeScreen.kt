package com.focusagent.ai.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Návrh UI pro domovskou obrazovku FocusAgent AI (Jetpack Compose)
 */
@Composable
fun HomeScreen(
    timerText: String = "25:00",
    activeTaskTitle: String = "Práce na projektu FocusAgent",
    onStartTimerClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Hlavička
        Text(
            text = "FocusAgent AI 🎯",
            style = MaterialTheme.typography.headlineMedium
        )

        // Hlavní časovač (Focus Timer)
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = timerText,
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onStartTimerClick) {
                    Text("Spustit soustředění")
                }
            }
        }

        // Aktuální úkol (Today's Tasks)
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Dnešní hlavní úkol:",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = activeTaskTitle,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
