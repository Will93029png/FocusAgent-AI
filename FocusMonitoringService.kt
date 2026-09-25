package com.focusagent.ai.service

import android.app.Service
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.focusagent.ai.engine.FocusAgentEngine
import com.focusagent.ai.model.AppCategory
import com.focusagent.ai.model.DistractionLevel
import com.focusagent.ai.model.FocusSession
import com.focusagent.ai.model.TrackedApp
import java.util.SortedMap
import java.util.TreeMap

/**
 * Android Služba běžící na pozadí (Foreground Service),
 * která v reálném čase monitoruje aktivní aplikaci na obrazovce.
 */
class FocusMonitoringService : Service() {

    private val engine = FocusAgentEngine()
    private var isRunning = false

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isRunning = true
        Log.d("FocusMonitoringService", "Služba pro monitorování aplikací byla spuštěna.")
        
        // Spuštění smyčky monitorování
        startMonitoringLoop()

        return START_STICKY
    }

    private fun startMonitoringLoop() {
        Thread {
            val session = FocusSession(id = "live_session", taskName = "Soustředění", isActive = true)

            while (isRunning) {
                val currentPackage = getForegroundApp()
                if (currentPackage != null) {
                    Log.d("FocusMonitoringService", "Aktivní aplikace na obrazovce: $currentPackage")

                    // Simulovaný převod balíčku na TrackedApp
                    val trackedApp = TrackedApp(
                        packageName = currentPackage,
                        appName = currentPackage.substringAfterLast('.'),
                        category = AppCategory.SOCIAL_MEDIA,
                        distractionLevel = if (currentPackage.contains("instagram") || currentPackage.contains("tiktok")) {
                            DistractionLevel.DISTRACTING
                        } else {
                            DistractionLevel.PRODUCTIVE
                        }
                    )

                    // Vyhodnocení agentem
                    val intervention = engine.evaluateIntervention(session, trackedApp)
                    if (intervention != null) {
                        Log.w("FocusMonitoringService", "AI Zásah: $intervention")
                    }
                }

                // Kontrola každé 3 sekundy
                Thread.sleep(3000)
            }
        }.start()
    }

    /**
     * Zjistí název balíčku aplikace, která je momentálně otevřená na popředí.
     */
    private fun getForegroundApp(): String? {
        val usageStatsManager = getSystemService(Context.USAGE_STATS_SERVICE) as? UsageStatsManager
            ?: return null

        val time = System.currentTimeMillis()
        val stats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            time - 1000 * 10,
            time
        )

        if (stats != null && stats.isNotEmpty()) {
            val mySortedMap: SortedMap<Long, UsageStats> = TreeMap()
            for (usageStats in stats) {
                mySortedMap[usageStats.lastTimeUsed] = usageStats
            }
            if (mySortedMap.isNotEmpty()) {
                return mySortedMap[mySortedMap.lastKey()]?.packageName
            }
        }
        return null
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        isRunning = false
        Log.d("FocusMonitoringService", "Služba monitorování byla zastavena.")
        super.onDestroy()
    }
}
