package com.focusagent.ai.engine

import com.focusagent.ai.model.TrackedApp

/**
 * Simulátor rozhraní pro On-Device AI (Qualcomm AI Hub / ONNX Runtime)
 * V reálné verzi bude volat lokálně spuštěný lehký jazykový model (SLM).
 */
class LocalAiAgent {

    /**
     * Vygeneruje personalizovanou motivační nebo upozorňující zprávu bez použití internetu.
     */
    fun generateContextualPrompt(currentApp: TrackedApp, userFocusGoal: String): String {
        // Zde v budoucnu proběhne inferenční volání lokálního AI modelu přímo na NPU procesoru
        return "[On-Device NPU Processed] Zaznamenán odklon k aplikaci '${currentApp.appName}'. " +
               "Pamatuj na svůj dnešní cíl: '$userFocusGoal'. Chceš se vrátit k práci?"
    }
}
