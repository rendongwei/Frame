package com.don.frame.util

import android.annotation.TargetApi
import android.app.*
import android.content.Context
import android.graphics.Color
import android.os.Build
import com.don.frame.manager.ActivityManager

object NotificationUtil {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun isNotificationEnabled(context: Context): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if ((context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).importance == NotificationManager.IMPORTANCE_NONE) {
                return false
            }
        }
        val mAppOpsManager = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

        var mAppOpsClass: Class<*>? = null
        try {
            mAppOpsClass = Class.forName(AppOpsManager::class.java.name)
            val checkOpNoThrowMethod = mAppOpsClass!!.getMethod(
                "checkOpNoThrow", Integer.TYPE, Integer.TYPE,
                String::class.java
            )
            val opPostNotificationValue = mAppOpsClass.getDeclaredField("OP_POST_NOTIFICATION")

            val value = opPostNotificationValue.get(Int::class.java) as Int
            return checkOpNoThrowMethod.invoke(
                mAppOpsManager,
                value,
                context.applicationInfo.uid,
                context.packageName
            ) as Int == AppOpsManager.MODE_ALLOWED
        } catch (e: Exception) {
        }

        return false
    }

    fun intentToNotification(context: Context) {
        ActivityManager.getInstance().intentToNotification(context)
    }

    fun createChannelGroup(context: Context, id: String, name: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannelGroup(NotificationChannelGroup(id, name))
        }
    }

    fun deleteChannelGroup(context: Context, id: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.deleteNotificationChannelGroup(id)
        }
    }

    fun createChannel(
        context: Context, id: String, name: String, description: String,
        groupId: String? = null,
        importance: Int = NotificationManager.IMPORTANCE_HIGH,
        lightEnable: Boolean = true,
        color: Int = Color.RED,
        vibrationEnable: Boolean = true,
        vibrationPattern: LongArray = longArrayOf(100, 200, 100)
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val mChannel = NotificationChannel(id, name, importance)
            if (!groupId.isNullOrEmpty()) {
                mChannel.group = groupId
            }
            mChannel.description = description
            mChannel.enableLights(lightEnable)
            mChannel.lightColor = color
            mChannel.enableVibration(vibrationEnable)
            mChannel.vibrationPattern = vibrationPattern
            mChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT)
            mNotificationManager.createNotificationChannel(mChannel)
        }
    }

    fun deleteChannel(context: Context, id: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.deleteNotificationChannel(id)
        }
    }
}