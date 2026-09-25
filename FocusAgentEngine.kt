package com.focusagent.ai.engine

import com.focusagent.ai.model.DistractionLevel
import com.focusagent.ai.model.FocusSession
import com.focusagent.ai.model.TrackedApp

/**
 * Hlavní mozek FocusAgent AI - vyhodnocuje stav soustředění a navrhuje intervence
 */
class FocusAgentEngine {

    /**
     * Zkontroluje, zda uživatel během aktivní relace neutekl k rušivé aplikaci
     */
    fun evaluateIntervention(session: FocusSession, currentApp: TrackedApp): String? {
        // Pokud relace není aktivní, agent zasahovat nemusí
        if (!session.isActive) return null

        return when (currentApp.distractionLevel) {
            DistractionLevel.DISTRACTING -> {
                "AI Agent: Pozor! Máš aktivní relaci soustředění. " +
                "Aplikace '${currentApp.appName}' tě odvádí od cílů. Vrať se ke svému úkolu!"
            }
            DistractionLevel.PRODUCTIVE -> {
                "AI Agent: Skvělá práce, pokračuj v produktivní činnosti v aplikaci ${currentApp.appName}."
            }
            DistractionLevel.NEUTRAL -> null
        }
    }
}
