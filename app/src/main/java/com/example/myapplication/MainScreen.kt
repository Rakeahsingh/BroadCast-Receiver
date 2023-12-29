package com.example.myapplication

import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun MainScreen(
) {

    val context = LocalContext.current

    SystemBroadcastReceiver(
        systemAction = Intent.ACTION_AIRPLANE_MODE_CHANGED
    ){ receiveIntent ->
        val action = receiveIntent?.action ?: return@SystemBroadcastReceiver
        if (action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            Toast.makeText(context, "AirPlane Mode Change", Toast.LENGTH_SHORT).show()
        }

    }

    SystemBroadcastReceiver(
        systemAction = WifiManager.WIFI_STATE_CHANGED_ACTION
    ){ receiveIntent ->
        val action = receiveIntent?.action ?: return@SystemBroadcastReceiver
        if (action == WifiManager.WIFI_STATE_CHANGED_ACTION){
            Toast.makeText(context, "Wifi State Change", Toast.LENGTH_SHORT).show()
        }

    }

}