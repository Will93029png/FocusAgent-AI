# Specifikace On-Device AI pro FocusAgent AI

## 1. Cílová architektura
- **Hardware:** Qualcomm Snapdragon NPU / Hexagon DSP
- **Runtime:** ONNX Runtime Mobile / Qualcomm AI Engine Direct SDK
- **Typ modelu:** Small Language Model (SLM), např. Llama-3.2-1B-Instruct nebo Phi-3-Mini (4-bit kvantizace)

## 2. Důvody pro On-Device řešení
1. **Nulová latence:** Okamžitá reakce při detekci rušivé aplikace.
2. **Ochrana soukromí:** Data o používání aplikací a seznam úkolů nikdy neopustí zařízení.
3. **Offline provoz:** AI agent funguje bez připojení k internetu.

## 3. Formát vstupního kontextu (Prompting)
```json
{
  "system_prompt": "Jsi asistent pro soustředění. Tvým úkolem je stručně a motivovaně vrátit uživatele k práci.",
  "user_context": {
    "active_task": "Příprava prezentace",
    "opened_app": "Instagram",
    "time_in_session": "12 minut"
  }
}
