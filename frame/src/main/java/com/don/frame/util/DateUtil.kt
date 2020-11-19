package com.don.frame.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    const val FORMAT_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss"
    const val FORMAT_Y_M_D_H_M = "yyyy-MM-dd HH:mm"
    const val FORMAT_Y_M_D = "yyyy-MM-dd"
    const val FORMAT_M_D_H_M_S = "MM-dd HH:mm:ss"
    const val FORMAT_M_D_H_M = "MM-dd HH:mm"
    const val FORMAT_M_D = "MM-dd"
    const val FORMAT_H_M_S = "HH:mm:ss"
    const val FORMAT_H_M = "HH:mm"

    private const val YEAR = 365 * 24 * 60 * 60
    private const val MONTH = 30 * 24 * 60 * 60
    private const val DAY = 24 * 60 * 60
    private const val HOUR = 60 * 60
    private const val MINUTE = 60

    private val mFormat by lazy { SimpleDateFormat() }

    // 获取某格式时间
    fun getFormatDate(timestamp: Long, format: String): String {
        try {
            mFormat.applyPattern(format)
            return mFormat.format(timestamp)
        } catch (e: Exception) {
        }
        mFormat.applyPattern(FORMAT_Y_M_D_H_M_S)
        return mFormat.format(timestamp)
    }

    // 获取简短时间
    fun getSimpleDate(timestamp: Long): String {
        return when {
            isSameDay(timestamp) -> getFormatDate(timestamp, FORMAT_H_M)
            isSameMonth(timestamp) -> getFormatDate(timestamp, FORMAT_M_D_H_M)
            isSameYear(timestamp) -> getFormatDate(timestamp, FORMAT_M_D_H_M)
            else -> getFormatDate(timestamp, FORMAT_Y_M_D_H_M)
        }
    }

    // 获取描述型时间
    fun getDescriptionDate(timestamp: Long): String {
        var currentTime = System.currentTimeMillis()
        var time = (currentTime - timestamp) / 1000
        return when {
            time > DAY -> getFormatDate(timestamp, getSimpleDate(timestamp))
            time > HOUR -> (time / HOUR).toString() + "小时前"
            time > MINUTE -> (time / MINUTE).toString() + "分钟前"
            else -> "刚刚"
        }
    }

    // 是否同一年
    fun isSameYear(timestamp: Long): Boolean {
        var currentCalendar = Calendar.getInstance()
        var calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp

        var year = calendar[Calendar.YEAR]
        var currentYear = currentCalendar[Calendar.YEAR]
        return year == currentYear
    }

    // 是否同一月
    fun isSameMonth(timestamp: Long): Boolean {
        var currentCalendar = Calendar.getInstance()
        var calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp

        var year = calendar[Calendar.YEAR]
        var month = calendar[Calendar.MONTH]

        var currentYear = currentCalendar[Calendar.YEAR]
        var currentMonth = currentCalendar[Calendar.MONTH]

        return year == currentYear && month == currentMonth
    }

    // 是否同一天
    fun isSameDay(timestamp: Long): Boolean {
        var currentCalendar = Calendar.getInstance()
        var calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp

        var year = calendar[Calendar.YEAR]
        var month = calendar[Calendar.MONTH]
        var day = calendar[Calendar.DAY_OF_MONTH]

        var currentYear = currentCalendar[Calendar.YEAR]
        var currentMonth = currentCalendar[Calendar.MONTH]
        var currentDay = currentCalendar[Calendar.DAY_OF_MONTH]

        return year == currentYear && month == currentMonth && day == currentDay
    }

    // 是否昨天
    fun isYesterday(timestamp: Long): Boolean {
        var yesterdayCalendar = Calendar.getInstance()
        yesterdayCalendar.add(Calendar.DAY_OF_MONTH, -1)
        var calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp

        var year = calendar[Calendar.YEAR]
        var month = calendar[Calendar.MONTH]
        var day = calendar[Calendar.DAY_OF_MONTH]

        var yesterdayYear = yesterdayCalendar[Calendar.YEAR]
        var yesterdayMonth = yesterdayCalendar[Calendar.MONTH]
        var yesterdayDay = yesterdayCalendar[Calendar.DAY_OF_MONTH]

        return year == yesterdayYear && month == yesterdayMonth && day == yesterdayDay
    }

    // 字符串转时间戳
    fun formatToTimestamp(date: String?, format: String?): Long? {
        if (date.isNullOrEmpty() || format.isNullOrEmpty()) {
            return null
        }
        var simpleDateFormat = SimpleDateFormat(format)
        try {
            return simpleDateFormat.parse(date)?.time
        } catch (e: Exception) {
        }
        return null
    }
}