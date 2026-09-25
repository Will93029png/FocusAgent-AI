package com.focusagent.ai.model

/**
 * Reprezentuje jednu úlohu v seznamu Today's Tasks
 */
data class Task(
    val id: String,
    val title: String,
    val isCompleted: Boolean = false,
    val category: String = "General"
)

/**
 * Reprezentuje stav časovače soustředění (Focus Timer)
 */
data class FocusSession(
    val durationMinutes: Int = 25,
    val remainingSeconds: Int = 1500,
    val isActive: Boolean = false,
    val completedSessionsToday: Int = 0
)
