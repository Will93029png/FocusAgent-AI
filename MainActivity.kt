package com.focusagent.ai

import android.app.AppOpsManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.focusagent.ai.service.FocusMonitoringService
import com.focusagent.ai.ui.HomeScreen

/**
 * Hlavní aktivita aplikace FocusAgent AI.
 * Řídí uživatelské rozhraní a kontroluje systémová oprávnění Androidu.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kontrola oprávnění ke statistikám užívání aplikací
        if (!hasUsageStatsPermission()) {
            requestUsageStatsPermission()
        } else {
            startFocusService()
        }

        setContent {
            HomeScreen(
                timerText = "25:00",
                activeTaskTitle = "Soustředěná práce na Android vývoji",
                onStartTimerClick = {
                    if (hasUsageStatsPermission()) {
                        startFocusService()
                        Toast.makeText(this, "Monitorování spuštěno!", Toast.LENGTH_SHORT).show()
                    } else {
                        requestUsageStatsPermission()
                    }
                }
            )
        }
    }

    private fun hasUsageStatsPermission(): Boolean {
        val appOps = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            appOps.unsafeCheckOpNoThrow(
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(),
                packageName
            )
        } else {
            appOps.checkOpNoThrow(
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(),
                packageName
            )
        }
        return mode == AppOpsManager.MODE_ALLOWED
    }

    private fun requestUsageStatsPermission() {
        Toast.makeText(this, "Povolte prosím přístup k datům o využití aplikací", Toast.LENGTH_LONG).show()
        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
        startActivity(intent)
    }

    private fun startFocusService() {
        val serviceIntent = Intent(this, FocusMonitoringService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
    }
}
