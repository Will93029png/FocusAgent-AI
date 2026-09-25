package com.focusagent.ai.model

/**
 * Úroveň rušení pro jednotlivé aplikace
 */
enum class DistractionLevel {
    PRODUCTIVE,   // Poznamky, Kalendář, Vzdělávání
    NEUTRAL,      // Systémové aplikace, Nastavení
    DISTRACTING   // Sociální sítě, Hry, Zábava
}

/**
 * Reprezentuje sledovanou aplikaci v systému Android
 */
data class TrackedApp(
    val packageName: String,
    val appName: String,
    val timeSpentMinutes: Long = 0,
    val distractionLevel: DistractionLevel = DistractionLevel.NEUTRAL
)
