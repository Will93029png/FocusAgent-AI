package com.focusagent.ai

import com.focusagent.ai.engine.FocusAgentEngine
import com.focusagent.ai.model.DistractionLevel
import com.focusagent.ai.model.FocusSession
import com.focusagent.ai.model.TrackedApp

/**
 * Simulace chování FocusAgent AI pro Proof of Concept (PoC)
 */
fun main() {
    val engine = FocusAgentEngine()

    // 1. Uživatel zapne Focus Timer na 25 minut
    val activeSession = FocusSession(durationMinutes = 25, isActive = true)
    println("--- SIMULACE: Start relace soustředění (25 minut) ---")

    // 2. Uživatel si otevře produktivní aplikaci (Notion/Poznámky)
    val app1 = TrackedApp(
        packageName = "com.notion.id",
        appName = "Notion",
        distractionLevel = DistractionLevel.PRODUCTIVE
    )
    val response1 = engine.evaluateIntervention(activeSession, app1)
    println("Uživatel otevřel: ${app1.appName}")
    println("Reakce AI: ${response1 ?: "Vše v pořádku (klid)"}\n")

    // 3. Uživatel podlehne pokušení a otevře rušivou aplikaci (TikTok)
    val app2 = TrackedApp(
        packageName = "com.zhiliaoapp.musically",
        appName = "TikTok",
        distractionLevel = DistractionLevel.DISTRACTING
    )
    val response2 = engine.evaluateIntervention(activeSession, app2)
    println("Uživatel otevřel: ${app2.appName}")
    println("Reakce AI: $response2\n")

    println("--- SIMULACE DOKONČENA ---")
}
