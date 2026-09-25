# FocusAgent AI 🎯
> **On-Device AI Assistant for Deep Work & Digital Wellbeing**

FocusAgent AI je inteligentní mobilní asistent navržený pro zvýšení soustředění a eliminaci digitálního rozptylování. Využívá lokální AI modely (On-Device AI) k vyhodnocování uživatelského chování v reálném čase přímo na zařízení – bez nutnosti připojení k internetu a s plným zachováním soukromí.

---

## 🏗️ Architektura a kódová základna (Proof of Concept)

Projekt obsahuje funkcionalitu navrženou v jazyce **Kotlin**:

- **`TaskModel.kt`**: Datové struktury pro správy úkolů (`Task`) a časovač soustředění (`FocusSession`).
- **`AppTrackerModel.kt`**: Logika kategorizace aplikací podle úrovně rušení (`PRODUCTIVE`, `NEUTRAL`, `DISTRACTING`).
- **`FocusAgentEngine.kt`**: Rozhodovací jádro AI agenta vyhodnocující neproduktivní chování.
- **`LocalAiAgent.kt`**: Návrh rozhraní pro spouštění lokálních AI modelů přes Qualcomm AI Hub / ONNX.
- **`MainSimulator.kt`**: Spustitelný simulátor ověřující chování agenta v reálném scénáři.

---

## 📱 Technický stack
- **Jazyk:** Kotlin
- **Cílová platforma:** Android (Optimized for Snapdragon / NPU)
- **AI Engine:** On-Device Small Language Models (SLM) via Qualcomm AI Hub / ONNX
- **Vývojové prostředí:** Mobile-native development (Acode, Termux, GitHub)

---

## 🚀 Jak spustit simulaci
Logiku projektu lze otestovat spuštěním souboru `MainSimulator.kt` v jakémkoliv vývojovém prostředí podporujícím Kotlin JVM.

---
*Created by [Viliam Kašuka / William Williams](https://github.com/Will93029png)*
