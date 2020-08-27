package com.don.frame.util

import android.content.BroadcastReceiver
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity

object BroadcastReceiverUtil {

    fun register(activity: AppCompatActivity?, broadcastReceiver: BroadcastReceiver, vararg actions: String) {
        var intentFilter = IntentFilter()
        actions.forEach {
            intentFilter.addAction(it)
        }
        activity?.registerReceiver(broadcastReceiver, intentFilter)
    }

    fun unregister(activity: AppCompatActivity?, broadcastReceiver: BroadcastReceiver) {
        activity?.unregisterReceiver(broadcastReceiver)
    }
}