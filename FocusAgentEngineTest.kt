package com.focusagent.ai.engine

import com.focusagent.ai.model.AppCategory
import com.focusagent.ai.model.DistractionLevel
import com.focusagent.ai.model.FocusSession
import com.focusagent.ai.model.TrackedApp

/**
 * Automatizované testy pro ověření spolehlivosti rozhodovacího jádra FocusAgentEngine.
 */
class FocusAgentEngineTest {

    private val engine = FocusAgentEngine()

    fun testInterventionOnDistraction() {
        val session = FocusSession(id = "1", taskName = "Vývoj PoC", isActive = true)
        val distractingApp = TrackedApp("com.instagram.android", "Instagram", AppCategory.SOCIAL_MEDIA, DistractionLevel.DISTRACTING)

        val result = engine.evaluateIntervention(session, distractingApp)
        
        check(result != null) { "Test selhal: Agent měl zasáhnout při otevření rušivé aplikace!" }
        println("✅ Test úspěšný: Agent správně detekoval rušení.")
    }

    fun testNoInterventionOnProductiveApp() {
        val session = FocusSession(id = "2", taskName = "Psaní kódu", isActive = true)
        val productiveApp = TrackedApp("com.github.android", "GitHub", AppCategory.DEVELOPMENT, DistractionLevel.PRODUCTIVE)

        val result = engine.evaluateIntervention(session, productiveApp)
        
        check(result?.contains("Skvělá práce") == true) { "Test selhal: Agent měl pochválit produktivní aplikaci!" }
        println("✅ Test úspěšný: Agent správně podpořil produktivní chování.")
    }
}
