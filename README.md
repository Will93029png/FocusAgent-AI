
# FocusAgent AI
> **Konstrukční návrh personalizovaného AI agenta pro Android (Digital Wellbeing & Ranní produktivita)**

**Autor:** Willy Am Kašuka (William Williams)  
**Datum:** Září 2026  
**Platforma:** Android (Kotlin, Qualcomm AI Hub, ONNX Runtime)

---

## 1. Úvod a Vize Projektu

**Vize:**  
Cílem projektu je vytvořit inteligentního on-device AI agenta pro systém Android, který kombinuje aktivní ochranu před neproduktivním scrollováním (Digital Wellbeing) s kontextovým ranním asistentem. Agent pomáhá uživateli okamžitě navázat na rozpracovanou práci a udržet pozornost u kreativních a pracovních aktivit.

---

## 2. Problém a Řešení

* **Problém:** Uživatelé po odemčení telefonu často podlehnou zvyku a automaticky otevírají sociální sítě (TikTok, Instagram), kde ztrácejí čas bezcílným scrollováním. Chybí jim okamžitý impuls k práci.
* **Řešení:** AI agent, který při ranním odemčení telefonu zobrazí přehled rozdělané práce z předchozího dne. Při pokusu o otevření neproduktivní aplikace aktivně nabídne vědomou volbu mezi pauzou a pokračováním v projektu.

---

## 3. Klíčové Funkce (Core Features)

* **3.1 Context-Aware Morning Dashboard (Ranní asistent)**
  * **Chytrý start dne:** Ihned po prvním ranním odemčení telefonu zobrazí agent celoobrazovkový přehled.
  * **Návrat k práci:** Na základě lokální historie nabídne tlačítko pro spuštění rozpracovaného úkolu z předchozího dne.

* **3.2 Digital Wellbeing Intervention (Aktivní ochrana pozornosti)**
  * **Detekce neproduktivity:** Aplikace sleduje spouštění vybraných neproduktivních aplikací.
  * **Chytrá překrývání (Overlay):** Místo tvrdého zablokování zobrazí okno s vědomou volbou: návrat k hlavnímu projektu, nebo měřená pauza.

* **3.3 On-Device AI & Privacy First (Lokální zpracování)**
  * **Ochrana soukromí:** Všechna data o aktivitě a texty úkolů zůstávají uložená pouze v zařízení.
  * **Běh bez internetu:** Využití úsporných lokálních LLM modelů přizpůsobených pro architekturu Qualcomm / Snapdragon.

---

## 4. Návrh Uživatelského Rozhraní (Wireframes & UX)

Tato kapitola popisuje vizuální strukturu a rozvržení hlavních prvků aplikace **FocusAgent AI**. Cílem rozhraní je minimalizovat rozptýlení a nabídnout okamžitou akci bez nutnosti složitého hledání.

### 4.1 Hlavní prvky ranní obrazovky (Focus Dashboard)
* **Přivítání a časový fokus:** Výrazný panel s přivítáním a časovačem pro rychlé zahájení pracovní relace.
* **Přehled denních úkolů (Today's Tasks):** Jasný seznam prioritních kroků navazujících na předchozí den s ukazatelem dokončených úkolů.
* **Rychlé odkazování (Quick Links):** Přímý přístup k integrovaným poznámkám a kalendáři pro zachování pracovní návaznosti.
* **Přehled aktivit a statistik:** Vizuální ukazatel odehraného soustředěného času a statistik produktivity.
* **Navigační panel:** Spodní lišta pro rychlé přepínání mezi domovskou stránkou, úkoly, analytikou a nastavením.

### 4.2 Vizuální drátový model (Wireframe)

copilot_image_1790345839028.jpeg


*Obrázek 1: Drátový model (wireframe) ranního rozhraní aplikace FocusAgent AI.*

---

## 5. Technická Architektura a Realizace

### 5.1 Klíčové Technologie a Platforma
* **Aplikace:** Android (Kotlin / Java).
* **AI Běhové prostředí:** Qualcomm AI Hub / ONNX Runtime pro lokální spouštění úsporných LLM modelů přímo na procesorech Snapdragon bez nutnosti internetového připojení.
* **Detekce neproduktivity:** Systémová rozhraní `UsageStatsManager` a `AccessibilityService` pro sledování spuštěných aplikací v reálném čase.
* **Zobrazení intervence:** Rozhraní `System Alert Window` (Overlay) pro zobrazení mírného upozornění přes neproduktivní aplikace.

### 5.2 Plán Realizace (Roadmapa)
1. **Fáze 1 (Koncept a Návrh):** Vytvoření kompletního návrhu UI/UX a struktury.
2. **Fáze 2 (Prototyp Android):** Vývoj základní Android aplikace pro detekci spouštěných aplikací a testování oken s upozorněním.
3. **Fáze 3 (Integrace AI):** Propojení aplikace s lokálním AI modelem přes Qualcomm AI Hub pro vyhodnocování kontextu a denních úkolů.
4. **Fáze 4 (Optimalizace):** Ladění spotřebybaterie a přizpůsobení pro různé nadstavby Androidu.

---

## 6. Závěr

Projekt **FocusAgent AI** představuje moderní přístup k digitální rovnováze. Propojuje lokální AI zpracování přímo na zařízení (On-Device AI) s prvky produktivity, čímž uživateli pomáhá šetřit čas, chránit soukromí a okamžitě se soustředit na důležité úkoly bez zbytečného rozptýlení.


